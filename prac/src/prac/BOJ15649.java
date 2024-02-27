package prac;

import java.util.Scanner;

public class BOJ15649 {
	static int n;
	static int m;
	static int num[];
	static int ret[];
	static boolean visit[];
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[n];
		ret = new int[m];
		visit = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			num[i] = i+1;
		}
		
		func(0);
		System.out.println(sb.toString());
		
	}
	
	private static void func(int cnt) {
		if(cnt == m) {
			for(int temp : ret) {
				sb.append(temp+" ");
			}
			sb.append('\n');
			return;
		}
		else {
			for(int i = 0; i < n; i++) {
				if(!visit[i]) {
					ret[cnt] = num[i];
					visit[i] = true;
					func(cnt+1);
					visit[i] = false;
				}
			}
		}
	}
}
