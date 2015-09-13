package ru.redenergy.itschool.task6;

public class Task6 {

	public static void main(String ... args) {
		try{
			int result = 10 / 0;
		} catch (ArithmeticException ex){
			System.out.println("На нуль делить нельзя");
		}
	}

}
