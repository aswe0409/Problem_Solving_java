package baekjoon_java;
// 칼 얻었을때 bfs랑 안 얻었을때 bfs 2개 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17836_공주님을구해라BFS2 {
	static int  n,m,t;
	static int di[] = {1,-1,0,0};
	static int dj[] = {0,0,-1,1};
	static int [][] arr;
	static boolean [][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		int b1 = bfs(); // 칼 안찾고 목적지 까지 가는 bfs
		int b2 = ka;(); //칼 찾고 목적지 까지 
		
		
	}
}
