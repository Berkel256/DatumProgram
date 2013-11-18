package leapyear;

public class JulianCalendar extends Calendar{
	public JulianCalendar(){
		name = "Julian Calendar";
		from = -45;
		to = 1581;
	}

	@Override
	public boolean isLeapYear(int year) {
		boolean isLeapYear = false;
		int checkYear = year % 4;
		if (checkYear == 0){
			isLeapYear = true;
		}
		return isLeapYear;
	}

}
