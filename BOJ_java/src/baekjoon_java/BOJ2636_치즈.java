package baekjoon_java;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2636_치즈 {
	static class Pos{
		int row, col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int time, last; // 다녹는데 걸리 시간. 다 녹기 직전 마지막 치즈 수
	
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		} 
		time = 0;
		
		while(true) {
			if(count() == 0) break;
			
			last = count();
			bfs();
			melt();
			time+=1;
		}
		System.out.println(time);
		System.out.println(last);
	}
	
	private static void bfs() {
		Queue<Pos> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];
		
		q.add(new Pos(0,0)); //0,0은 무조건 외부 공기
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			for(int k = 0; k < 4; k++) {
				int newi = temp.row + di[k];
				int newj = temp.col + dj[k];
				if(newi >= 0 && newi < N && newj >=0 && newj < M) {
					if(map[newi][newj] == 0 && !visit[newi][newj]) {
						q.add(new Pos(newi, newj));
						visit[newi][newj] = true;
					}
					else if(map[newi][newj]==1) {
						map[newi][newj]=2;
					}
				}
			}
		}
	}
	
	private static void melt() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2) map[i][j]=0;
			}
		}
		
	}
	static int count() { // 치즈 개수 세기
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) cnt++;
			}
		}
		return cnt;
	}

}
