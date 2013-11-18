package controller;

import view.DatumInput;


public class Controller{
	private Model model;
	private DatumInput view;

	public Controller(){
		model = new Model(this);
		view = new DatumInput(this, model);
		model.addObserver(view);
	}

	public static void main(String[] args){
		new Controller();
	}

	public void isLeapYear(int number) {
		model.isLeapYear(number);
	}


}
