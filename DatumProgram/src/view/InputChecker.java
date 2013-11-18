package view;

public class InputChecker {

	public boolean isNumber(String input){
		String pattern = "-?\\d+";
		boolean isNumber = input.matches(pattern);
		return isNumber;
	}
}
