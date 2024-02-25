package baekjoon_java;

import java.util.Scanner;

public class ex1074 {
	static int cnt = 0;
	static int r;
	static int c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 
		r = sc.nextInt();
		c = sc.nextInt();

		func(0,0);
	}
	
	static void func(int row, int col) {
		if(row == r && col == c) {
			System.out.println(cnt);
			return;
		}
		
		
	}
}
