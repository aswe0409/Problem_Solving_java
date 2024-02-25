package swea_java;

import java.util.Scanner;

public class ex6485 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int [] stop = new int[5001];
			int n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				for(int j = a; j <=b; j++) {
					stop[j] +=1;
				}
			}
			
			int p = sc.nextInt();
			System.out.print("#"+t);
			for(int i = 0; i < p; i++) {
				int c = sc.nextInt();
				System.out.print(" "+stop[c]);
			}
			System.out.println();
			
		}
	}
}
