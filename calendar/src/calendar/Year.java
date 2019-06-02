package calendar;
public class Year {
	private int year;
	private int dayOfTheWeekFirstDay;
	private boolean leapYear;
	private Month month[] = new Month[13];
	
	public static boolean leap(int year) {
		if(year%4==0) 
			if(year%100==0) 
				if(year%400==0) return true;
				else return false;
			else return true;
		else return false;
	} 
	
	public static int yearDays(int year) {
		int days;
		if(leap(year)) days=366; else days=365; 
		return days;
	}
	public static int period(int k, int ramda) {
		if(k<0) k += ramda;
		return k;
	}
	
	public static int dayOfTheWeekNumber(int year) {		
		int weekNumber = 10;
		switch(period((year-2000)%28,28) /*28*/) {
		case 0: weekNumber = 6; break;
		case 1: weekNumber = 1; break;
		case 2: weekNumber = 2; break;
		case 3: weekNumber = 3; break;
		case 4: weekNumber = 4; break;
		case 5: weekNumber = 6; break;
		case 6: weekNumber = 0; break;
		case 7: weekNumber = 1; break;
		case 8: weekNumber = 2; break;
		case 9: weekNumber = 4; break;
		case 10: weekNumber = 5; break;
		case 11: weekNumber = 6; break;
		case 12: weekNumber = 0; break;
		case 13: weekNumber = 2; break;
		case 14: weekNumber = 3; break;
		case 15: weekNumber = 4; break;
		case 16: weekNumber = 5; break;
		case 17: weekNumber = 0; break;
		case 18: weekNumber = 1; break;
		case 19: weekNumber = 2; break;
		case 20: weekNumber = 3; break;
		case 21: weekNumber = 5; break;
		case 22: weekNumber = 6; break;
		case 23: weekNumber = 0; break;
		case 24: weekNumber = 1; break;
		case 25: weekNumber = 3; break;
		case 26: weekNumber = 4; break;
		case 27: weekNumber = 5; break;
		}
		return weekNumber;
	}
	
	public Year(int year){
		this.year = year;
		this.dayOfTheWeekFirstDay = dayOfTheWeekNumber(this.year);
		this.leapYear = leap(this.year);
		for(int i=1;i<13;i++) {this.month[i] = new Month(this.year, i, this.leapYear, this.dayOfTheWeekFirstDay);}
	}
	
	public void print_year() {
		int i;
		for(i=1;i<13;i++) this.month[i].printMonth();
	}
	
	//アクセッサー
	public int getYear(){ return this.year; }
	public int getDayOfTheWeekFirstDay(){ return this.dayOfTheWeekFirstDay; }
	public boolean getLeapYear(){ return this.leapYear; }
	public Month[] getMonth (){ return this.month; }	
}
