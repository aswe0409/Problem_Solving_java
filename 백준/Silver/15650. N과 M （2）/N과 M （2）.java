import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static boolean [] visited;
	static int ret [];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		ret = new int[m];
		combi(0,0);
	}
	static void combi(int cnt, int start) {
		if(cnt == m) {
			for(int n : ret) {
				System.out.print(n+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < n; i++) {
			ret[cnt] = i+1;
			combi(cnt + 1, i + 1);
		}
	}
}