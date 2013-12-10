package main;

import java.security.InvalidParameterException;

import core.ConverterManager;

/*
 * The FrameAdapter is used to separate the Manager from
 * the Frame.
 * 
 */

//Controller
public class ConverterAdapter {
	
	private ConverterManager manager;
	

	public ConverterAdapter(ConverterManager manager){
		this.manager = manager;
	}
	
	public double fahrenheitToCelsius(String toConvert) throws NumberFormatException, 
	InvalidParameterException{
		double value = Double.parseDouble(toConvert);
		return this.manager.convertFahrenheitToCelsius(value);
	}

	public double celsiusToFahrenheit(String toConvert) throws NumberFormatException, 
	InvalidParameterException{
		double value = Double.parseDouble(toConvert);
		return this.manager.convertCelsiusToFahrenheit(value);
	}
	
	public String fizzBuzzConvert(String startValue, String endValue) throws NumberFormatException, 
	InvalidParameterException{
		return this.manager.fizzBuzz(Integer.parseInt(startValue), Integer.parseInt(endValue));
	}

}
