package ru.redenergy.itschool.task3;

import java.util.Scanner;

public class Task3 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String tempScanned = scan.nextLine();
			if(tempScanned != null){
				System.out.println(sumDigits(Integer.parseInt(tempScanned)));
			}
		}
		scan.close();
	}
	
	/**
	 * Sum all digits in given number
	 * @param number
	 * @return sum of digits
	 */
	public static int sumDigits(int number){
		String temp = Integer.toString(number);
		int result = 0;
		for(int i = 0; i < temp.length(); i++){
			result += Integer.parseInt(String.valueOf(temp.charAt(i)));
		}
		return result;
	}
	
}
