package controller;

import java.util.Observable;

import leapyear.CalendarException;
import leapyear.LeapYearCalculator;

public class Model extends Observable{
	private Controller controller;
	private String answer;
	private LeapYearCalculator leapYearCalculator;

	public Model(Controller controller){
		this.controller = controller;
		leapYearCalculator = new LeapYearCalculator();
		answer = "";
	}

	public void isLeapYear(int number) {
		// TODO Auto-generated method stub
		try {
			if (leapYearCalculator.isLeapYear(number)){
				answer = number + " is a leapyear.";
			}
			else {
				answer = number + " is not a leapyear.";
			}
		} catch (CalendarException e) {
			answer = e.getMessage();
			e.printStackTrace();
		}
		setChanged();
		notifyObservers();
	}

	public String getAnswer(){
		return answer;
	}

}
