package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import core.FizzBuzzConverter;

public class FizzBuzzConverterTest {
	private static FizzBuzzConverter converter;
	private static int min;
	private static int max;
	private static int fizzBuzzValue;
	private static int buzzValue;
	private static int fizzValue;
	
	@BeforeClass
	public static void setUp() {
		converter = new FizzBuzzConverter();
		max = 100;
	}

	@Before
	public void initVariables(){
		fizzValue = 3;
		buzzValue = 5;
		fizzBuzzValue = 15;
		min = 1;
	}
	
	@Test
	public void testFizzBuzz(){
		while (fizzBuzzValue < max){
			assertEquals("FizzBuzz", converter.convert(fizzBuzzValue,fizzBuzzValue));
			fizzBuzzValue += fizzBuzzValue;
		}
	}

	@Test
	public void testFizz(){
		while (fizzValue < max){
			if (fizzValue % buzzValue != 0){
				assertEquals("Fizz", converter.convert(fizzValue,fizzValue));
			}
			fizzValue += fizzValue;
		}
	}	
	
	@Test
	public void testBuzz(){
		while (buzzValue < max){
			if (buzzValue % fizzValue != 0){
				assertEquals("Buzz", converter.convert(buzzValue,buzzValue));
			}
			buzzValue += buzzValue;
		}
	}
	@Test
	public void testNumber(){
		while(min < max){
			if (min % fizzValue != 0 && min % buzzValue != 0){
				assertEquals(String.valueOf(min), converter.convert(min, min));
			}
			min ++;
		}
	}
}
