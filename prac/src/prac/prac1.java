package prac;

import java.util.Random;

public class prac1 {
	public static void main(String[] args) {
		int num = 1;
		
		try {
			System.out.println("code 1, num:" + num);
			int i = 1/num;
			System.out.println("code 2 - 예외없음");
		}
		catch(ArithmeticException e) {  
			System.out.println("code 3 - 예외처리 완료");
		}
		System.out.println("code4");
	}
}
