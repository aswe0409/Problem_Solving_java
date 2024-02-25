package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260_dfsbfs {
	static int n;
	static int m;
	static int start;
	
	static int [][] arr;
	static boolean [] visited;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		for(int i = 0; i < m; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(str.nextToken());
			int col = Integer.parseInt(str.nextToken());
			arr[row][col] = arr[col][row] = 1;
		}
		
		visited = new boolean[n+1];
		dfs(start);
		System.out.println();
		q = new LinkedList<Integer>();
		visited = new boolean[n+1];
		bfs(start);
		
	}
	
	private static void dfs(int start) {
		visited[start] = true;
		System.out.print(start+" ");
		
		for(int i = 0; i <= n; i++) {
			if(arr[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(int start) {
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp+" ");
			
			for(int i = 0; i <= n; i++) {
				if(arr[temp][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
}
