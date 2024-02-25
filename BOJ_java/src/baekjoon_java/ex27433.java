package baekjoon_java;

import java.util.Scanner;

public class ex27433 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fact(n));
	}
	
	private static long fact(int num) {
		if(num <= 1) {
			return 1;
		}
		else {
			return num * fact(num-1);
		}
	}
}
