package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178_미로탐색 {
	static class Pos{
		int row, col, cnt;
		public Pos(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
	static int [] di = {1,-1,0,0};
	static int [] dj = {0,0,-1,1};
	static int n;
	static int m;
	static int [][]arr;
	static Queue<Pos> q;
	static boolean [][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		bfs(0,0,1);
		
	}
	
	private static void bfs(int nowi, int nowj, int nowcnt) {
		q.offer(new Pos(nowi, nowj, nowcnt));
		visited[nowi][nowj] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			if(temp.row == n-1 && temp.col == m-1) {
				System.out.println(temp.cnt);
				return;
			}
			for(int k = 0; k < 4; k++) {
				int newi = temp.row + di[k];
				int newj = temp.col + dj[k];
				if(newi >=0 && newi < n && newj >= 0 && newj < m && !visited[newi][newj] && arr[newi][newj] == 1) {
		
					visited[newi][newj] = true;
					q.offer(new Pos(newi, newj, temp.cnt+1));
				}
			}
		}
		return;
	}
}
