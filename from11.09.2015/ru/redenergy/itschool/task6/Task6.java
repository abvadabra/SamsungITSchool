package ru.redenergy.itschool.task6;

public class Task6 {

	public static void main(String ... args) {
		try{
			int result = 10 / 0;
		} catch (ArithmeticException ex){
			System.out.println("\u041d\u0430 \u043d\u0443\u043b\u044c \u0434\u0435\u043b\u0438\u0442\u044c \u043d\u0435\u043b\u044c\u0437\u044f");
		}
	}

}
