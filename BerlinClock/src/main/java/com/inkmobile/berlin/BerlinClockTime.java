package com.inkmobile.berlin;

import com.inkmobile.ClockTime;


/**
 * Class which represent time in Berlin Clock Format
 * @author ravi
 *
 */
public class BerlinClockTime implements ClockTime {

    int hour;
    int minute;
    int seconds;
    
    /**
     * Constructor must not be called, instead use BerlinClockTimeBuilder
     * @param hour
     * @param minute
     * @param seconds
     */
    BerlinClockTime(int hour, int minute, int seconds) {
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
	}

	/* (non-Javadoc)
	 * @see com.inkmobile.ClockTime#getRepresentation()
	 */
	public String getRepresentation(){
		StringBuilder builder = new StringBuilder();
		prepareSeconds(builder);
		builder.append(" ");
		prepareHours(builder);
		builder.append(" ");
		prepareMinutes(builder);
		return builder.toString();
	}
	/*
	 * Method to return Berlin Clock seconds representation of Time as String
	 */
	void prepareSeconds(StringBuilder builder){
		if(seconds % 2 == 0){
			builder.append("Y");
		}else{
			builder.append("O");
		}
	}
	
	/*
	 * Method to return Berlin Clock hours representation of Time as String
	 */
	void prepareHours(StringBuilder builder){
		int localHour = this.hour;
		char hourBulbs[] = {'O','O','O', 'O', ' ', 'O','O','O', 'O'};
		int i=0;
		//For each 5 Hours we have one Red bulb, mark them
		while(localHour > 4){
			hourBulbs[i++] = 'R';
			localHour = localHour - 5;
		}
		i=5;
		//For last 4 Hours we have one Red bulb for each hour, mark them
		while(localHour > 0){
			hourBulbs[i++] = 'R';
			localHour = localHour - 1;
		}
		for(char oneBulb:hourBulbs){
			builder.append(oneBulb);
		}
	}
	
	/*
	 * Method to return Berlin Clock Minutes representation of Time as String
	 */
	void prepareMinutes(StringBuilder builder){
		char minuteBulbs[] = {'O','O','O', 'O','O','O','O', 'O','O','O','O', ' ', 'O','O','O','O' };
		int i=0;
		int minuteCount = 5;
		//For every 5 minutes we have one Yellow or Red bulb, so mark them
		while(minuteCount <= minute){
			if(minuteCount % 15 == 0){
				minuteBulbs[i++] = 'R';	
			}else{
				minuteBulbs[i++] = 'Y';
			}
			minuteCount = minuteCount + 5;
		}
		i = 12;
		minuteCount = 0;
		//For last 4 minutes we have one Yellow bulb of each Minute
		while(minuteCount < minute % 5){
			minuteBulbs[i++] = 'Y';
			minuteCount = minuteCount + 1;
		}
		for(char oneBulb:minuteBulbs){
			builder.append(oneBulb);
		}
	}
    
    

}
