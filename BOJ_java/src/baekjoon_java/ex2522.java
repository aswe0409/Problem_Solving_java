package baekjoon_java;

import java.util.Scanner;

public class ex2522 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			for(int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k <i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int k = i; k < n; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
