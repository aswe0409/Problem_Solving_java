package baekjoon_java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1926_그림 {
	static class Pos{
		int row, col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	static int n; // 세로
	static int m; //가로
	static int []di = {1,-1,0,0};
	static int [] dj = {0,0,-1,1};
	
	static int[][] arr;
	static boolean[][] visit;

	static Queue<Pos> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		visit = new boolean[n][m];
		q = new LinkedList<>();
		
		int max = 0;
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 1 && !visit[i][j]) {
					cnt+=1;
					int temp = bfs(i,j);
					
					if(max < temp) max = temp;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}
	
	private static int bfs(int nowi, int nowj) {
		int cnt = 1;
		q.offer(new Pos(nowi, nowj));
		visit[nowi][nowj] = true;
		
		while(!q.isEmpty()) {
			Pos temp =q.poll();
			
			for(int k = 0; k < 4; k++) {
				int newi = temp.row + di[k];
				int newj = temp.col + dj[k];
				
				if(newi >=0 && newi < n && newj >= 0 && newj < m 
						&& !visit[newi][newj] && arr[newi][newj] == 1) {
					visit[newi][newj] = true;
					q.offer(new Pos(newi, newj));
					cnt +=1;
				}
			}
		}
		return cnt;
	}
}
