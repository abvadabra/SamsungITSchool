package ru.redenergy.itschool.task5;

/**
 * Represents displayed time on digital watch
 */
public class DisplayedTime {
	
	public final int hours;
	public final int minuts;
	
	public DisplayedTime(int hours, int minuts){
		this.hours = hours;
		this.minuts = minuts;
	}
	
	@Override
	public String toString(){
		return hours + " " + minuts;
	}
}
