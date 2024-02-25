package baekjoon_java;

import java.util.Scanner;

public class ex2523 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = i; j < n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
