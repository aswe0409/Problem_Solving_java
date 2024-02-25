package baekjoon_java;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2606_바이러스 {
	static int V; //정점 수
	static int E; // 간선 수
	static int cnt;
	static int [][] arr; //인접 행렬
	static Queue<Integer> q;
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		arr = new int[V+1][V+1];
		visited = new boolean[V+1];
		q = new LinkedList<Integer>();
			
		for(int i  = 0; i < E; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			arr[row][col] = arr[col][row] = 1;
		}
		
		bfs(1);
		System.out.println(cnt);
	}
	private static void bfs(int start) {
		q.offer(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int k = 1; k <= V; k++) {
				if(arr[temp][k] == 1 && !visited[k]) {
					cnt +=1;
					visited[k] = true;
					q.offer(k);
				}
			}
		}
		return;
	}

}
