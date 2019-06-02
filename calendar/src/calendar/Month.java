package calendar;

public class Month {
	private int dayOfTheWeekNumber;
	private int year;
	private int month;
	private int days;
	private Day day[] = new Day[32];
	
	public static int monthDays (int month, boolean leapYear) {
		int days;
		int monthDays[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(month!=2 || !leapYear)  days=monthDays[month]; else days = 29; 
		return days;
	}
	
	public int dec_dayOfTheWeekNumber(int month,boolean leapYear, int dayOfTheWeekFirstDay) {
		int dayOfTheWeekNumber;
		int i, sumDays=0;
		int monthDays[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(leapYear) monthDays[2]++;
		for(i=0;i<month;i++) sumDays += monthDays[i];
		dayOfTheWeekNumber = ((sumDays % 7) + dayOfTheWeekFirstDay) % 7;
		return dayOfTheWeekNumber;
	}
	
	//コンストラクタ
	public Month(int year, int month, boolean leapYear, int dayOfTheWeekFirstDay) {	
		this.dayOfTheWeekNumber = dec_dayOfTheWeekNumber(month, leapYear, dayOfTheWeekFirstDay);
		this.days = monthDays (month, leapYear);
		this.year = year;
		this.month = month;
		for(int i=1;i<this.days+1;i++) this.day[i] = new Day(i, this.month, this.year, this.dayOfTheWeekNumber);
	}
	//アクセッサー
	public int getDayOfTheWeekNumber() {return this.dayOfTheWeekNumber;}
	public int getDays() {return this.days;}
	public Day[] getDay() {return this.day;}
	
	//出力メソッド
	public void printMonth() {
		int i,j=1;
		System.out.printf("--------------------\n");
		System.out.printf("      ");
		System.out.printf("%4d  %2d\n",this.year, this.month);
		System.out.printf("Su Mo Tu We Th Fr Sa\n");
		for(i=0;i<this.dayOfTheWeekNumber;i++) System.out.printf("   ");
		for(i=this.dayOfTheWeekNumber;i<7;i++) {System.out.printf("%2d ",j); j++;}
		System.out.printf("\n");
		while(true){
			for(i=0;i<7;i++) {
				System.out.printf("%2d ",j);
				j++;
				if(j>this.days)break;
			}
			System.out.printf("\n");
			if(j>this.days)break;
		}
		System.out.printf("--------------------\n");
	}
}
