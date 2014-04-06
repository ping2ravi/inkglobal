package com.inkmobile.berlin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author ravi
 *
 */
public class BerlinClockTimeBuilder {

    private static Pattern timePattern = Pattern.compile("([01]+[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])");

	private String time;
	
	/**
	 * Build a BerlinClockTime.
	 * This method is not thread safe
	 * It can  be converted to factory method and pass String time as parameter and will become ThreadSafe
	 * @return
	 */
	public BerlinClockTime build(){
		if(time == null){
			throw new IllegalArgumentException("Time can not be null");
		}
		Matcher matcher = timePattern.matcher(time);
        if(!matcher.matches()){
        	throw new IllegalArgumentException("Invalid time format ["+time+"]");
        }
        int hour = Integer.parseInt(matcher.group(1));
        int minute = Integer.parseInt(matcher.group(2));
        int seconds = Integer.parseInt(matcher.group(3));
        return new BerlinClockTime(hour, minute, seconds);
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
