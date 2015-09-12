package ru.redenergy.itschool.task1;

import java.util.Scanner;

/**
 * @author RedEnergy
 */
public class Task1 {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String tempScanned = scan.nextLine();
			if(tempScanned != null){
				System.out.println(getLastDigit(Integer.parseInt(tempScanned)));
			}
		}
		scan.close();
	}
	/**
	 * Evaluates last digit of the given number
	 * @param number
	 * @return last digit
	 */
	public static int getLastDigit(int number){
		return number % 10;
	}
}
