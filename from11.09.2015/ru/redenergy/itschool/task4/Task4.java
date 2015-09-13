package ru.redenergy.itschool.task4;

import java.util.Scanner;

public class Task4 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String tempScanned = scan.nextLine();
			if(tempScanned != null){
				System.out.println(nextEvenNumber(Integer.parseInt(tempScanned)));
			}
		}
		scan.close();
	}
	
	/**
	 * Returns next even number for the given N
	 * @param n - given number
	 * @return next even number for n
	 */
	public static int nextEvenNumber(int n){
		return (n / 2 * 2) + 2;
	}
	
}
