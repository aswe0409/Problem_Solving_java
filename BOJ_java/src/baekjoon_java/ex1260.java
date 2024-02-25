package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex1260 {
	static int [][] arr;
	static boolean[] visit;
	static int N,M, start;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		start = Integer.parseInt(st.nextToken()); // 탐색 시작할 정점
		q = new LinkedList<Integer>();
		
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		for(int i = 0; i < M; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(str.nextToken());
			int col = Integer.parseInt(str.nextToken());
			
			arr[row][col] = 1;
			arr[col][row] = 1;
		}
		
		dfs(start);
		visit = new boolean[N+1];
		System.out.println();
		bfs(start);
	}
	
	private static void dfs(int start) {
		visit[start] = true;
		System.out.print(start+" ");
		
		for(int i = 0; i <= N; i++) {
			if(arr[start][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}	
	}
	
	private static void bfs(int start) {
		q.add(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp+" ");
	
			for(int i = 1; i <= N; i++) {
				if(arr[temp][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}
}
