package baekjoon_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ex15652 {
	static int N;
	static int M;
	static int [] ret;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ret = new int[M];
		comb(0,1);
		System.out.println(sb);
		
	}
	
	private static void comb(int cnt, int start) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(cnt == M) {
			for(int num: ret) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		else {
			for(int i = start; i <= N; i++) {
				ret[cnt] = i;
				comb(cnt+1, i);
			}
		}
	}
}
