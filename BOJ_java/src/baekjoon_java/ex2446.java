package baekjoon_java;

import java.util.Scanner;

public class ex2446 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			for(int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < 2 * n - 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < n-i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < 2 *i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
