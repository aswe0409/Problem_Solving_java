import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int [] ret, num;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ret = new int[m];
		num = new int[n];
		visited = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		combi(0,0);
	}
	static void combi(int cnt, int start) {
		if(cnt == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(ret[i]+ " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i < n; i++) {
			if(!visited[i]) {
				ret[cnt] = num[i];
				visited[i] = true;
				combi(cnt + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}