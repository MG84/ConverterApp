package ui;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

import main.ConverterAdapter;

public class CelsiusFahrenheitFrame extends ConverterFrame implements ActionListener {
	
	private static final long serialVersionUID = 12L;
	private Label labelFirstValue;
	private Label labelSecondValue;
	private TextField textFieldFirstValue;
	private TextField textFieldSecondValue;
	private TextArea textArea;
	private ConverterAdapter adapter;
	private final String name =  "Celsius / Fahrenheit Converter";
	private Button buttonStart;
	
	public CelsiusFahrenheitFrame(ConverterAdapter adapter) {
		this.setUp();
		this.adapter = adapter;
		initializeComponents();
		addComponents();
		addListeners();
	}

	protected void addListeners() {

		buttonStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String fResult = "# Celsius to Fahrenheit: \n";
				String cResult = "# Fahrenheit to Celsius: \n";
				
				try {
					fResult += String.valueOf(adapter.celsiusToFahrenheit(textFieldFirstValue.getText()))+ "\n";
				}
				catch (InvalidParameterException ex) {fResult += ex.getLocalizedMessage() +"\n";}
				catch (NumberFormatException ne){fResult += "/ \n";}
				
				try {
					cResult += String.valueOf(adapter.fahrenheitToCelsius(textFieldSecondValue.getText()));
				}
				catch (InvalidParameterException ex) {cResult += ex.getLocalizedMessage() +"\n";}
				catch (NumberFormatException ne){cResult += "/ \n ";}
				textArea.setText(fResult + cResult);
			}
		});
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
		
		labelFirstValue = new Label("from Celsius:");
		textFieldFirstValue = new TextField(5);
		labelSecondValue = new Label("from Fahrenheit");
		textFieldSecondValue = new TextField(5);
		textArea = new TextArea("Insert the value you want to convert \n" +
								"in its own field, then press enter.",5,30, 
								TextArea.SCROLLBARS_BOTH);
		buttonStart = new Button("start");

	}

	public void actionPerformed(ActionEvent e) {
		String result = "result in Celsius: ";
		try {
			result += String.valueOf(adapter.fahrenheitToCelsius(e.getActionCommand()));
		} catch (NumberFormatException ne){
			result += "Invalid Fahrenheit Input";
		}
		textArea.setText(result);
	}

	@Override
	public String name(){
		return this.name;
	}
}