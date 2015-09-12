package ru.redenergy.itschool.task2;

import java.util.Scanner;

/**
 * @author RedEnergy
 */
public class Task2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String tempScanned = scan.nextLine();
			if(tempScanned != null){
				System.out.println(getNumberOfTens(Integer.parseInt(tempScanned)));
			}
		}
		scan.close();
	}
	
	/**
	 * Evaluates number of tens in given number
	 * @param number
	 * @return number of tens
	 */
	public static int getNumberOfTens(int number){
		return number / 10;
	}

}
