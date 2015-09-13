package ru.redenergy.itschool.task5;

import java.util.Scanner;

public class Task5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String tempScanned = scan.nextLine();
			if(tempScanned != null){
				System.out.println(formatMinutsToSimpleTime(Integer.parseInt(tempScanned)));
			}
		}
		scan.close();
	}
	
	public static DisplayedTime formatMinutsToSimpleTime(int amountMinuts){
		int hours = amountMinuts % 1440 / 60;
		int minuts = amountMinuts % 1440 % 60;
		return new DisplayedTime(hours, minuts);
	}

}
