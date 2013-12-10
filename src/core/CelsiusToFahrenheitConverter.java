package core;

import java.security.InvalidParameterException;

public class CelsiusToFahrenheitConverter {

	private final double ABSOLUTE_ZERO_CELSIUS = -273.15;
	private final double ABSOLUTE_ZERO_FAHRENHEIT = -459.67;
	private final double DECIMALS = 10000;

	
	public double convert(double value) {
		if (value < ABSOLUTE_ZERO_CELSIUS)
			throw new InvalidParameterException("Input must be above " +
					"the Absolute zero value: " + ABSOLUTE_ZERO_CELSIUS);
		return (double)Math.round(((value * 1.8) + 32) * DECIMALS) / DECIMALS;
	}

	public double revert(double value) {
		if (value < ABSOLUTE_ZERO_FAHRENHEIT)
			throw new InvalidParameterException("Input must be above " +
					"the Absolute zero value: " + ABSOLUTE_ZERO_FAHRENHEIT);
		return (double)Math.round(((value - 32) / 1.8) * DECIMALS) / DECIMALS;
	}

}
