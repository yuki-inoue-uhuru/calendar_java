package calendar;
//import java.lang.Math;
import java.util.Scanner;
public class Main {
	public static void inputYearMonth(int[] init){
		Scanner scan =  new Scanner(System.in);
		System.out.println("年を入力して下さい");
		init[0] = scan.nextInt();
		System.out.println("月を入力して下さい");
		while(true) {
		    init[1] = scan.nextInt();
		    if(0<init[1] && init[1]<=12)break;
		    System.out.println("有効な月を入力して下さい");
		}
		//scan.close();
	}
	
	public static void inputDay(int[] init, int days){
		Scanner scan =  new Scanner(System.in);
		System.out.println("予定を確認する日付を入力して下さい");
		while(true) {
			init[2] = scan.nextInt();
			if(0<init[2] && init[2]<=days)break;
			System.out.println("有効な日付を入力して下さい");
		}
		scan.close();
	}
	
    public static void main(String[] args) {
	    int[] init = new int[3];	    
	    inputYearMonth(init);                //出力年と月を取得
	    Year year = new Year(init[0]);       //Year型のオブジェクトを作成
	    year.getMonth()[init[1]].printMonth();
	    inputDay(init,year.getMonth()[init[1]].getDays());
	    year.getMonth()[init[1]].getDay()[init[2]].printDay();
	    //year.print_year();
    }   
}
