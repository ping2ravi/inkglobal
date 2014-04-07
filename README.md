inkglobal
=========


Interview Stage Status : Awaiting Result



Problem : 

Create a representation of the Berlin Clock for a given time (hh::mm:ss).

The Berlin Uhr (Clock) is a rather strange way to show the time. On the top of the clock there is a yellow lamp that blinks on/off every two seconds. The time is calculated by adding rectangular lamps.

The top two rows of lamps are red. These indicate the hours of a day. In the top row there are 4 red lamps. Every lamp represents 5 hours. In the lower row of red lamps every lamp represents 1 hour. So if two lamps of the first row and three of the second row are switched on that indicates 5+5+3=13h or 1 pm.

The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4. In the first row every lamp represents 5 minutes. In this first row the 3rd, 6th and 9th lamp are red and indicate the first quarter, half and last quarter of an hour. The other lamps are yellow. In the last row with 4 lamps every lamp represents 1 minute.

The lamps are switched on from left to right.

Test Cases (Y = Yellow, R = Red, O = Off)

Input     Result 

00:00:00  Y OOOO OOOO OOOOOOOOOOO OOOO

13:17:01  O RROO RRRO YYROOOOOOOO YYOO

23:59:59  O RRRR RRRO YYRYYRYYRYY YYYY

24:00:00  Y RRRR RRRR OOOOOOOOOOO OOOO


Solution/Design : 
=================

There are two aspects of this problem

A) Understand and validates the input time

B) Represent the time into String format of Bulbs

To start with I started with a interface which will represent the Clock Time, and its one implementation which can convert time to Berlin Clock Format.

For Understanding and validating the time I created a Builder, which can understand the time and keep it in proper time segments. i.e. hours, minutes and seconds.

It was possible to do it even using Factory Method on ClockTime implementation itself, but then representation logic will be tightly bound to input format. With builder we have put the responsbility of understanding the time to builder. So in future if input time format need to change, we can have another builder, but ClockTime implementation will not change.
i.e. in future if we say time can come in format ss:mm:hh etc.





