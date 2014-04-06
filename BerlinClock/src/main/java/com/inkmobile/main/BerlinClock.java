package com.inkmobile.main;

import com.inkmobile.ClockTime;
import com.inkmobile.berlin.BerlinClockTimeBuilder;


/**
 * Hello world!
 *
 */
public class BerlinClock 
{
    public static void main( String[] args)
    {
    	if(args.length != 1){
    		System.err.println("Please pass time parameter(i.e. 07:56:13)");
    		return;
    	}
    	BerlinClockTimeBuilder berlinClockTimeBuilder = new BerlinClockTimeBuilder();
    	berlinClockTimeBuilder.setTime(args[0]);
    	ClockTime berlinClockTime = berlinClockTimeBuilder.build();
    	System.out.println(berlinClockTime.getRepresentation());
    }
}
