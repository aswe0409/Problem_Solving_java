package swea_java;

import java.util.Scanner;

public class ex2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1; tc <= TC; tc++) {
			int n = sc.nextInt();
			int sum = 0;
			int start = n /2;
		
			for(int i = 0; i < n; i++) {
				char [] farm = new char[n];
				String str = sc.next();
				farm = str.toCharArray();
				
				if(i <= start) {
					for(int j = start - i; j <= start + i; j++) {
						sum = sum + farm[j] - '0';
					}
				}
				else {
					for(int j = i - start; j < n-(i-start); j++)
						sum = sum + farm[j] - '0';
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
