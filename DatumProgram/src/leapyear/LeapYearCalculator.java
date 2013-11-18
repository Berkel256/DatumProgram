package leapyear;

import java.util.HashSet;

public class LeapYearCalculator {
	private Calendar romanCalendar, julianCalendar, gregorianCalendar;
	private HashSet<Calendar> calendars;
	public LeapYearCalculator(){
		julianCalendar = new JulianCalendar();
		gregorianCalendar = new GregorianCalendar();
		calendars = new HashSet<Calendar>();
		calendars.add(julianCalendar);
		calendars.add(gregorianCalendar);
	}

	public boolean isLeapYear(int year) throws CalendarException{
		Calendar calendar = getCalendar(year);
		boolean leapYear = calendar.isLeapYear(year);
		return leapYear;
	}

	private Calendar getCalendar(int year) throws  CalendarException{
		for (Calendar calendar : calendars){
			if(calendar.containsYear(year)){
				return calendar;
			}
		}
		throw(new CalendarException());
	}


}