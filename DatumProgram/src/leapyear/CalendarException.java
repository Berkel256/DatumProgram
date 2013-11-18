package leapyear;

public class CalendarException extends Exception {
	public static final String MESSAGE = "Don't know if leapyear, because couldn't find a calendar for the year.";
	public CalendarException(){
		System.err.println(MESSAGE);
	}

	public String getMessage(){
		return MESSAGE;
	}
}
