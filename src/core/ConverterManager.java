package core;

import java.security.InvalidParameterException;

public class ConverterManager {
	
	private FizzBuzzConverter fizzBuzzConverter;
	private CelsiusToFahrenheitConverter celsiusToFahrenheitConverter;
	
	public void initializeConverters() {
		
		this.celsiusToFahrenheitConverter = new CelsiusToFahrenheitConverter();
		this.fizzBuzzConverter = new FizzBuzzConverter();
	}
	public double convertCelsiusToFahrenheit(double value) throws InvalidParameterException{
		return this.celsiusToFahrenheitConverter.convert(value);
	}
	
	public double convertFahrenheitToCelsius(double value) throws InvalidParameterException{
		return this.celsiusToFahrenheitConverter.revert(value);
	}
	
	public String fizzBuzz(int startValue, int endValue) throws InvalidParameterException{
		return this.fizzBuzzConverter.convert(startValue, endValue);
	}

}
