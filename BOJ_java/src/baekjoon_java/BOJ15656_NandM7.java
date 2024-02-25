package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15656_NandM7 {
	static int n;
	static int m;
	static int []num;
	static int [] ret;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num = new int[n];
		ret = new int[m];
		
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
			for(int temp : ret) {
				sb.append(temp+" ");
			}
			sb.append('\n');
			return;
		}
		else {
			for(int i = 0 ; i < n; i++) {
				ret[cnt] = num[i];
				func(cnt+1);
			}
		}
	}
}
