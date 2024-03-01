package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468_안전영역 {
	static class Pos{
		int row, col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	static int di[] = {1,-1,0,0};
	static int dj[] = {0,0,-1,1};
	static int n;
	static int arr[][];
	static boolean visit[][];
	static Queue<Pos> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for(int j = 0; j < n; j++) {
				int arr = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 1 && !visit[i][j]) {
					bfs(i,j);
					cnt +=1;
				}
			}
		}
		System.out.println(cnt);
	}
	
	private static void bfs(int nowi, int nowj) {
		q = new LinkedList<>();
		visit = new boolean[n][n];
		q.offer(new Pos(nowi, nowj));
		visit[nowi][nowj] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			
			for(int k = 0; k < 4; k++) {
				int newi = temp.row + di[k];
				int newj = temp.col + dj[k];
				
				if(newi >= 0 && newi < n && newj >= 0 && 
						newj < n && !visit[newi][newj] && arr[newi][newj] == 1) {
					q.offer(new Pos(newi, newj));
					visit[newi][newj] = true;
					
				}
			}
		}
		return;
	}
}
