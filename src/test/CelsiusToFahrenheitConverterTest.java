package test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.CelsiusToFahrenheitConverter;

public class CelsiusToFahrenheitConverterTest {

	private CelsiusToFahrenheitConverter converter;
	private double scaleIntersect;
	private double absouluteZeroCelsius;
	private double absouluteZeroFahrenheit;
	private double fahrenheitBoilingPoint;
	private double fahrenheitFreezingPoint;
	private double celsiusBoilingPoint;
	private double celsiusFreezingPoint;
	private double deltaValue;

	@Before
	public void setUp() throws Exception {
		converter = new CelsiusToFahrenheitConverter();
		scaleIntersect = -40.0;
		absouluteZeroCelsius = -273.15;
		absouluteZeroFahrenheit = -459.67;
		celsiusFreezingPoint = 0.0;
		celsiusBoilingPoint = 100.0;
		fahrenheitFreezingPoint = 32.0;
		fahrenheitBoilingPoint = 212.0;
		deltaValue = 0.01;
	}
	@Test
	public void testIntersect() {
		assertEquals(scaleIntersect, converter.convert(scaleIntersect), 0);
		assertEquals(scaleIntersect, converter.revert(scaleIntersect), 0);
	}
	
	@Test
	public void testAbsoluteZero() {
		
		try{converter.convert(absouluteZeroCelsius-deltaValue);}
		catch (InvalidParameterException msg){assertTrue(true);}
		
		try{converter.revert(absouluteZeroFahrenheit-deltaValue);}
		catch (InvalidParameterException msg){assertTrue(true);}
		
		assertEquals(absouluteZeroCelsius, converter.revert(absouluteZeroFahrenheit), 0);
		assertEquals(absouluteZeroFahrenheit, converter.convert(absouluteZeroCelsius), deltaValue);
	}
	
	@Test
	public void testScalePoints(){
		
		assertEquals(fahrenheitBoilingPoint, converter.convert(celsiusBoilingPoint), 0);
		assertEquals(celsiusBoilingPoint, converter.revert(fahrenheitBoilingPoint), 0);
		assertEquals(fahrenheitFreezingPoint, converter.convert(celsiusFreezingPoint), 0);
		assertEquals(celsiusFreezingPoint, converter.revert(fahrenheitFreezingPoint), 0);

	}

	@Test
	public void testRuleOfThumb(){
		assertEquals(50, converter.convert(10), 0);
		assertEquals(10, converter.revert(50), 0);

		assertEquals(0, converter.convert(-17.8), 0.04);
		assertEquals(-17.8, converter.revert(0), 0.03);

		assertEquals(100, converter.convert(37.8), 0.04);
		assertEquals(37.8, converter.revert(100), 0.03);
	}

	@After
	public void tearDown() throws Exception {
	}

}
