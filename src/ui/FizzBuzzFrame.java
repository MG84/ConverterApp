package ui;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

import main.ConverterAdapter;

public class FizzBuzzFrame extends ConverterFrame implements ActionListener {
	
	private static final long serialVersionUID = 13L;
	private Label labelFirstValue;
	private Label labelSecondValue;
	private TextField textFieldFirstValue;
	private TextField textFieldSecondValue;
	private TextArea textArea;
	private Button buttonStart;
	private ConverterAdapter adapter;
	private final String name = "Fizz Buzz Converter";
	
	public FizzBuzzFrame(ConverterAdapter adapter) {
		setUp();
		this.adapter = adapter;
		initializeComponents();
		addComponents();
		addListeners();

	}

	protected void addListeners() {
		textFieldFirstValue.addActionListener(this);
		textFieldSecondValue.addActionListener(this);
		buttonStart.addActionListener(this);
	}

	
	protected void addComponents() {
		add(labelFirstValue);
		add(textFieldFirstValue);
		add(labelSecondValue);
		add(textFieldSecondValue);
		add(textArea);		
		add(buttonStart);
	}

	protected void initializeComponents() {
		
		labelFirstValue = new Label("from Value:");
		textFieldFirstValue = new TextField(5);
		labelSecondValue = new Label("to Value:");
		textFieldSecondValue = new TextField(5);
		textArea = new TextArea("Insert the values in the fields \n" +
								"press enter.",5,30, 
								TextArea.SCROLLBARS_BOTH);
		buttonStart = new Button("start");
	}

	public void actionPerformed(ActionEvent e) {
		String result = "Result of FizzBuzz: ";
		try {
			result += String.valueOf(adapter.fizzBuzzConvert(textFieldFirstValue.getText(), 
					textFieldSecondValue.getText()));
		} catch (InvalidParameterException ex) {
			result += ex.getLocalizedMessage();
		}
		catch (NumberFormatException ne){
			result += "Invalid FizzBuzz input";
			}
		textArea.setText(result);
	}
	
	@Override
	public String name(){
		return this.name;
	}
}