package view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import controller.Model;

public class DatumInput extends JFrame implements Observer{
	private Controller controller;
	private Model model;
	private InputChecker check;
	private JPanel panel;
	private JLabel explainLabel, answerLabel;
	private JButton checkButton;
	private JTextField inputYear;


	public DatumInput(Controller controller, Model model){
		super("Datum Program");
		this.controller = controller;
		this.model = model;
		check = new InputChecker();

		initializeGui();
	}

	private void initializeGui(){
		setSize(500,200);
		setLayout(new FlowLayout(FlowLayout.LEFT));

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		add(panel);
		explainLabel = new JLabel("Enter Year to check, if it is a leapyear: ");
		inputYear = new JTextField();
		inputYear.setMaximumSize(new Dimension(150,50));
		checkButton = new JButton("Check");
		answerLabel = new JLabel("");



		//add to panel
		panel.add(explainLabel);
		panel.add(inputYear);
		panel.add(checkButton);
		panel.add(answerLabel);

		//Listener
		checkButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				answerLabel.setText("pressed");

				String input = inputYear.getText();

				if (check.isNumber(input)){
					controller.isLeapYear(Integer.parseInt(input));
				}
				else {
					answerLabel.setText("Year must consist of numbers only");
				}
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		answerLabel.setText(model.getAnswer());
	}


}
