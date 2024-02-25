package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ15657_NandM9 {
	static int n;
	static int m;
	static int [] num;
	static HashSet<String> ret;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num = new int[n];
		ret = new HashSet<String>();
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(num);
		func(0);
		System.out.println(sb.toString());
	}
	
	private static void func(int cnt) {
		if(cnt == m) {
			for(String temp : ret) {
				sb.append(temp+" ");
			}
			sb.append('\n');
			return;
		}
		else {
			for(int i = 0; i < n; i++) {
				ret.add(String.valueOf(num[i]));
				func(cnt+1);
			}
		}
	}
}
