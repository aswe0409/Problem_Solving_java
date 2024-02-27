package prac;

import java.util.Scanner;

public class BOJ15650 {
	static int n;
	static int m;
	static int num[];
	static int ret[];
	//static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[n];
		ret = new int[m];
		//visit = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			num[i] = i+1;
		}
		
		func(0,0);
		System.out.println(sb.toString());
	}
	
	private static void func(int cnt, int start) {
		if(cnt == m) {
			for(int temp : ret) {
				sb.append(temp+" ");
			}
			sb.append('\n');
			return;
		}
		else {
			for(int i = start; i < n; i++) {
				ret[cnt] = num[i];
				func(cnt+1, i+1);
			}
		}
	}
}
