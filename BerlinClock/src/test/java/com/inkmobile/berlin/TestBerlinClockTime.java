package com.inkmobile.berlin;

import org.junit.Before;
import org.junit.Test;

import com.inkmobile.berlin.BerlinClockTime;
import com.inkmobile.berlin.BerlinClockTimeBuilder;

import static org.junit.Assert.*;

public class TestBerlinClockTime {

	BerlinClockTimeBuilder berlinClockTimeBuilder;
	
	@Before
	public void init(){
		berlinClockTimeBuilder = new BerlinClockTimeBuilder();
	}
	
	/*
	 * given : time is provided in correct format and seconds is in odd number 
	 * then : prepraeSecond will return O
	 */
	@Test
	public void test01_prepareSeconds(){
		String expectedSecondRepresentation = "O";
		berlinClockTimeBuilder.setTime("00:00:13");
		BerlinClockTime berlinClockTime = berlinClockTimeBuilder.build();
		StringBuilder stringBuilder = new StringBuilder();
		berlinClockTime.prepareSeconds(stringBuilder);
		assertEquals(expectedSecondRepresentation, stringBuilder.toString());
	}
	
	/*
	 * given : time is provided in correct format and seconds is in Even number 
	 * then : prepraeSecond will return Y
	 */
	@Test
	public void test02_prepareSeconds(){
		String expectedSecondRepresentation = "Y";
		berlinClockTimeBuilder.setTime("00:00:14");
		BerlinClockTime berlinClockTime = berlinClockTimeBuilder.build();
		StringBuilder stringBuilder = new StringBuilder();
		berlinClockTime.prepareSeconds(stringBuilder);
		assertEquals(expectedSecondRepresentation, stringBuilder.toString());
	}
	
	/*
	 * given : time is provided in correct format 
	 * then : prepqre hour will return expected Hour representation
	 */
	@Test
	public void test03_prepareHours(){
		String[] expectedHours = {"OOOO OOOO","OOOO ROOO","OOOO RROO","OOOO RRRO","OOOO RRRR","ROOO OOOO","ROOO ROOO","ROOO RROO","ROOO RRRO"
				,"ROOO RRRR","RROO OOOO","RROO ROOO","RROO RROO","RROO RRRO","RROO RRRR","RRRO OOOO","RRRO ROOO","RRRO RROO","RRRO RRRO"
				,"RRRO RRRR","RRRR OOOO","RRRR ROOO","RRRR RROO","RRRR RRRO"};
		
		//first check that we have 24 representations 
		assertEquals(24, expectedHours.length);

		for(int i=0;i<24;i++){
			if(i < 10){
				berlinClockTimeBuilder.setTime("0"+i+":00:14");	
			}else{
				berlinClockTimeBuilder.setTime(i+":00:14");
			}
				
			BerlinClockTime berlinClockTime = berlinClockTimeBuilder.build();
			StringBuilder stringBuilder = new StringBuilder();
			berlinClockTime.prepareHours(stringBuilder);
			assertEquals(expectedHours[i], stringBuilder.toString());
		}
		
	}
	
	/*
	 * given : time is provided in correct format 
	 * then : prepqre Minute will return expected Minute representation
	 */
	@Test
	public void test04_prepareMinutes(){
		String[] expectedMinutes = {"OOOOOOOOOOO OOOO","OOOOOOOOOOO YOOO","OOOOOOOOOOO YYOO","OOOOOOOOOOO YYYO","OOOOOOOOOOO YYYY",
				"YOOOOOOOOOO OOOO","YOOOOOOOOOO YOOO","YOOOOOOOOOO YYOO","YOOOOOOOOOO YYYO", "YOOOOOOOOOO YYYY","YYOOOOOOOOO OOOO",
				"YYOOOOOOOOO YOOO","YYOOOOOOOOO YYOO","YYOOOOOOOOO YYYO","YYOOOOOOOOO YYYY","YYROOOOOOOO OOOO","YYROOOOOOOO YOOO",
				"YYROOOOOOOO YYOO","YYROOOOOOOO YYYO","YYROOOOOOOO YYYY","YYRYOOOOOOO OOOO","YYRYOOOOOOO YOOO","YYRYOOOOOOO YYOO",
				"YYRYOOOOOOO YYYO","YYRYOOOOOOO YYYY","YYRYYOOOOOO OOOO","YYRYYOOOOOO YOOO","YYRYYOOOOOO YYOO","YYRYYOOOOOO YYYO",
				"YYRYYOOOOOO YYYY","YYRYYROOOOO OOOO","YYRYYROOOOO YOOO","YYRYYROOOOO YYOO","YYRYYROOOOO YYYO","YYRYYROOOOO YYYY",
				"YYRYYRYOOOO OOOO","YYRYYRYOOOO YOOO","YYRYYRYOOOO YYOO","YYRYYRYOOOO YYYO","YYRYYRYOOOO YYYY","YYRYYRYYOOO OOOO",
				"YYRYYRYYOOO YOOO","YYRYYRYYOOO YYOO","YYRYYRYYOOO YYYO","YYRYYRYYOOO YYYY","YYRYYRYYROO OOOO","YYRYYRYYROO YOOO",
				"YYRYYRYYROO YYOO","YYRYYRYYROO YYYO","YYRYYRYYROO YYYY","YYRYYRYYRYO OOOO","YYRYYRYYRYO YOOO","YYRYYRYYRYO YYOO",
				"YYRYYRYYRYO YYYO","YYRYYRYYRYO YYYY","YYRYYRYYRYY OOOO","YYRYYRYYRYY YOOO","YYRYYRYYRYY YYOO","YYRYYRYYRYY YYYO",
				"YYRYYRYYRYY YYYY"};
		//first check that we have 60 representations 
		assertEquals(60, expectedMinutes.length);
		for(int i=0;i<60;i++){
			if(i < 10){
				berlinClockTimeBuilder.setTime("00:0"+i+":14");	
			}else{
				berlinClockTimeBuilder.setTime("00:"+i+":14");
			}
			BerlinClockTime berlinClockTime = berlinClockTimeBuilder.build();
			StringBuilder stringBuilder = new StringBuilder();
			berlinClockTime.prepareMinutes(stringBuilder);
			assertEquals(expectedMinutes[i], stringBuilder.toString());
		}
		
	}

}
