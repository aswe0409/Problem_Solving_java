package baekjoon_java;

import java.util.Scanner;

public class ex10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println(fibo(n));
	}
	
	private static int fibo(int n) {
		if(n == 0) return 0;
		if(n == 1 || n == 2) {
			return 1;
		}
		else {
			return fibo(n-2) + fibo(n-1);
		}
	}
}
