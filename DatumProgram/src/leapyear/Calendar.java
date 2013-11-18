package leapyear;

public abstract class Calendar {
	protected  int from, to;
	protected  String name;
	protected Calendar calendar;

	public Calendar() {
		calendar = this;
	}

	public Calendar getCalendar(){
		return calendar;
	}

	public String getCalendarName(){
		return name;
	}

	public int getCalendarYearBegin(){
		return from;
	}

	public int getCalendarYearEnd(){
		return to;
	}

	public abstract boolean isLeapYear(int year);

	public boolean containsYear(int year){
		boolean yearInCalendar = false;
		if (year >= from && year <= to){
			yearInCalendar = true;
		}
		return yearInCalendar;
	}
}
