package swea_java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA2117_홈방범서비스 {
	static class Pos{
		int row, col;
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static int n; // 개수
	static int m; // 비용
	static int [][]map;
	static Queue<Pos> q;
	static int []di = {1,-1,0,0};
	static int []dj = {0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int test = 1; test <= tc; test++) {
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n][n];
			int max = 0;
			q = new LinkedList<>();
			
			for(int i =0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			} 
			for(int k = 1; k <=n; k++) {
				int price = k * k +(k -1) * (k-1);
				for(int i =0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						int temp = bfs(i, j, price);
						if(max < temp) max = temp;
					}
				}
			}

		}
	}
	
	private static int bfs(int nowi, int nowj, int price) {
		q.offer(new Pos(nowi, nowj));
		
		if(!q.isEmpty()) {
			
		}
		return 0;
	}
}
