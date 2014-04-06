package com.inkmobile.berlin;

import org.junit.Before;
import org.junit.Test;

import com.inkmobile.ClockTime;
import com.inkmobile.berlin.BerlinClockTimeBuilder;

import static org.junit.Assert.*;

public class TestBerlinClockTimeBuilder {

	BerlinClockTimeBuilder berlinClockTimeBuilder;
	
	@Before
	public void init(){
		berlinClockTimeBuilder = new BerlinClockTimeBuilder();
	}
	
	/*
	 * given : time is not provided to Builder
	 * then : builder shud throw IllegalArgumentException
	 */
	@Test(expected=IllegalArgumentException.class)
	public void test01_build(){
		berlinClockTimeBuilder.build();
	}

	/*
	 * given : time is provided in wrong format
	 * then : builder should throw IllegalArgumentException
	 */
	@Test(expected=IllegalArgumentException.class)
	public void test02_build(){
		berlinClockTimeBuilder.setTime("Wrong time");
		berlinClockTimeBuilder.build();
	}

	/*
	 * given : time is provided in wrong format
	 * then : builder should throw IllegalArgumentException
	 */
	@Test(expected=IllegalArgumentException.class)
	public void test03_build(){
		berlinClockTimeBuilder.setTime("24:00:00");
		berlinClockTimeBuilder.build();
	}
	
	/*
	 * given : time is provided in correct format and start of the day
	 * then : builder should be able to build BerlinClockTime and representation shud be 
	 * O OOOO OOOO OOOOOOOOOOO OOOO
	 */
	@Test
	public void test04_build(){
		String dayStartRepresentation = "Y OOOO OOOO OOOOOOOOOOO OOOO";
		berlinClockTimeBuilder.setTime("00:00:00");
		ClockTime clockTime = berlinClockTimeBuilder.build();
		assertEquals(dayStartRepresentation, clockTime.getRepresentation());
	}
	
	/*
	 * given : time is provided in correct format and end of the day
	 * then : builder should be able to build BerlinClockTime and representation shud be 
	 * Y RRRR RRRO YYRYYRYYRYY YYYY
	 */
	@Test
	public void test05_build(){
		String dayStartRepresentation = "O RRRR RRRO YYRYYRYYRYY YYYY";
		berlinClockTimeBuilder.setTime("23:59:59");
		ClockTime clockTime = berlinClockTimeBuilder.build();
		assertEquals(dayStartRepresentation, clockTime.getRepresentation());
	}

}
