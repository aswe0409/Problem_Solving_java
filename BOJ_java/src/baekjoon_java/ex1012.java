package baekjoon_java;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ex1012 {
	static class Pos{
		int row, col;
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
	}
	
	static int[][] arr;
	static Queue<Pos> q;
	static int[] di = {0,-1,0,1};
	static int[] dj = {1,0,-1,0};
	static int M;
	static int N;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt(); // 테케 갯수
		
		for(int tc = 0; tc < TC; tc++) {
			M = sc.nextInt(); // 가로 
			N = sc.nextInt(); // 세로
			int K = sc.nextInt(); // 배추 개수
			arr = new int[N][M];
			int cnt = 0;
			//배추 위치 1로 바꾸기
			for(int i =0; i < K; i++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				
				arr[col][row] = 1;
			}
			for(int i = 0; i < N; i++) {
				for(int j =0; j < M; j++) {
					if(arr[i][j] == 1) {
						cnt +=1;
						//bfs(i,j);
						dfs(i,j);
					}
				}
			}
			System.out.println(cnt);	
		}
	}
	
	private static void bfs(int i, int j) {
		q = new LinkedList<>();
		q.offer(new Pos(i,j));
		
		if(q.isEmpty()) return;
		
		while (!q.isEmpty()) {
			Pos temp = q.poll();
			for(int k = 0; k < 4; k++) {
				int ni = temp.row + di[k];
				int nj = temp.col + dj[k];
				
				if(ni >=0 && ni < N && nj >=0 && nj < M && arr[ni][nj] == 1) {
					arr[ni][nj] = 0;
					q.offer(new Pos(ni,nj));
				}
			}
		}

		
		return;
	}
	
	private static void dfs(int i, int j) {
		arr[i][j] = 0;
		
		for(int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			
			if(ni >=0 && ni < N && nj >=0 && nj < M && arr[ni][nj] == 1) {
				arr[ni][nj] = 0;
				dfs(ni,nj);
			}
		}
		return;
	
	}
}
