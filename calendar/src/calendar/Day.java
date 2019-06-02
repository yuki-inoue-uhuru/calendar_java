package calendar;
import java.util.*;
import java.io.*;

public class Day {
	private int year;
	private int month;
	private int day;
	private int dayOfWeekNum;
	private Map<String,String> todo = new HashMap<String,String>();
  
	public Day(int day,int month, int year, int fDayOfWeekNum) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.dayOfWeekNum = WeekNum(day, fDayOfWeekNum);
		setTodo("todo_list.csv");
	}
  
	public static int WeekNum(int day, int fDayOfWeekNum) {
		fDayOfWeekNum += day%7-1; if(fDayOfWeekNum>6) fDayOfWeekNum -= 7; if(fDayOfWeekNum==-1) fDayOfWeekNum=6;
		return fDayOfWeekNum;
	}
	
	public void setTodo(String fname) {
		int i =0;
		String line;
		String[][] data = new String[100][3];
		String year = String.format("%d", this.year);
		String month = String.format("%02d", this.month);
		String day = String.format("%02d", this.day);
		String toDay = year+"-"+month+"-"+day;		
		try {
			File f = new File(fname);
			BufferedReader br = new BufferedReader(new FileReader(f));
			while((line = br.readLine())!= null) {	
				data[i] = line.split(",",0);
				i++;
			}
			br.close();
		}catch (IOException e){
			System.out.println(e);
		}
		for(String[] todoData:data) if(toDay.equals(todoData[0])) this.todo.put(todoData[1],todoData[2]);
	}
	
	public void printDay() {
		int i=0,j=0;
		String[] title = new String[this.todo.size()];
		String[] todo = new String[this.todo.size()];
		String[] dayOfWeek = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
		for (String key : this.todo.keySet()) { title[i]=key; i++; } 
		for (String value : this.todo.values()) { todo[j]=value; j++; }
		System.out.printf("-------------------------------------\n");
		System.out.printf("           %4d/%2d/%2d  %s          \n",this.year,this.month,this.day,dayOfWeek[this.dayOfWeekNum]);
		System.out.printf("---------------やる事リスト------------\n\n");
		for(i=0;i<this.todo.size();i++){
			System.out.printf(" title: %s\n",title[i]);
			System.out.printf(" todo: %s\n\n",todo[i]);
		}
		System.out.printf("-------------------------------------\n");
	}
}
