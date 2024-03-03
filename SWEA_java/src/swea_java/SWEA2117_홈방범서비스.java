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
	static int ret;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int test = 1; test <= tc; test++) {
			n = sc.nextInt();
			m = sc.nextInt();
			ret = 0;
			map = new int[n][n];
			int max = 0;
			q = new LinkedList<>();
			
			for(int i =0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			} 
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					bfs(i, j); // 모든칸을 서비스 영역의 중심으로 놓고 K영역 넓혀가면서 수익 계산해보기
				}
			}

			System.out.println("#"+test+" "+ret);
		}
	}
	
	private static void bfs(int nowi, int nowj) {
		q.offer(new Pos(nowi, nowj));
		boolean[][] visit = new boolean[n][n];
		
		visit[nowi][nowj] = true;
		int k = 1; // 현재 서비스 영역의 크기는 중심 1칸
		int house = 0; // 서비스 받는 가정집 개수
		while(!q.isEmpty()) {
			int size = q.size();
		
			for(int s = 0; s < size; s++) {
				Pos temp = q.poll();
				if(map[temp.row][temp.col] == 1) {
					house+=1;
				}
				
				for(int d = 0; d < 4; d++) {
					int newi = temp.row + di[d];
					int newj = temp.col + dj[d];
					if(newi>=0 && newi<n && newj>=0 && newj<n && !visit[newi][newj]) {
						q.add(new Pos(newi, newj));
						visit[newi][newj] = true;
					}	
				}
			}
			int cost = k*k+(k-1)*(k-1); // 현재 서비스 하는 영역의 지출
			int income = house*m; // 현재까지 영역의 누적 고객 가정집 수익

			if(cost <= income) {
				ret = Math.max(ret, house);
			}
			k++;
		}
	}
}
