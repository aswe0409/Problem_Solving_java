package baekjoon_java;

import java.util.Arrays;
import java.util.Scanner;

public class ex15650 {
	static int n;
	static int m;
	static int[] ret; // 결과 담을 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		ret = new int[m];

		combi(0,1);
		
	}
	private static void combi(int cnt, int start) {
		if(cnt == m) {
			for(int num : ret) {
				System.out.print(num+" ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i = start; i <= n; i++) {
				ret[cnt] = i;
				combi(cnt+1, i+1);
			}
		}
	}
	
}
