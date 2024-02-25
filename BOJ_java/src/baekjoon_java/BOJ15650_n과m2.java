package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650_n과m2 {
	static int n;
	static int m;
	static int[] num; // 후보 숫자
	static int [] ret; // 결과 담을 배열
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num = new int[n];
		ret = new int[m];
		
		for(int i = 0 ; i < n; i++) {
			num[i] = i+1;
		}
		comb(0, 0);
		System.out.println(sb.toString());
	}
	private static void comb(int cnt, int start) {
		if(cnt == m) { //종료조건
			for(int temp : ret) {
				sb.append(temp+" ");
			}
			sb.append('\n');
			return;
		}
		else {
			for(int i = start; i < n; i++) {
				ret[cnt] = num[i];
				comb(cnt+1, i+1);
			}
		}
	}
}
