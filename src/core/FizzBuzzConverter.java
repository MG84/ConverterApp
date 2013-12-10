package core;

import java.security.InvalidParameterException;

public class FizzBuzzConverter {
	
	public String fizzBuzz(int value) {
		String result = "";
		if ((value % 3) == 0)
			result += "Fizz";
		if ((value % 5) == 0)
			result += "Buzz";
		if (result.isEmpty())
			result = String.valueOf(value);
		return result;
	}

	public String convert(int pivot, int endPoint) {
		if (pivot > endPoint)
			throw new InvalidParameterException("inputs must be in ascending position" +
					" from left to right");
		if (pivot == endPoint)
			return fizzBuzz(pivot);
		return fizzBuzz(pivot) + ", " + convert(pivot +1, endPoint);
	}
}