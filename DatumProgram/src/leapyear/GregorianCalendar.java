package leapyear;

public class GregorianCalendar extends Calendar{
	public GregorianCalendar(){
		name = "Gregorian Calendar";
		from = 1582;
		to = Integer.MAX_VALUE;
	}
	@Override
	public boolean isLeapYear(int year) {
		boolean isLeapYear = false;
		int check4Year = year % 4;
		int check100Year = year % 100;
		int check400Year = year % 400;
		// every 4 years, every 100 years not, but every 400 years
		if ((check4Year==0 && check400Year==0) || (check4Year==0 && check100Year!=0)){
			isLeapYear = true;
		}
		return isLeapYear;
	}

}
