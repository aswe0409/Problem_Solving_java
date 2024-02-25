package baekjoon_java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ex7576 {
	static class Pos{
		int row, col;
		public Pos(int row, int col) {
			this.row = row; // 세로
			this.col = col; // 가로
		}
	}
	static int N; //세로
	static int M; //가로
	static int[][] arr;
	static int[] di = {0,-1,0,1};
	static int[] dj = {1,0,-1,0};
	static Queue<Pos> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N][M];
		int ret = 0;
		q = new LinkedList<>();

		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j <M; j++) {
				if(arr[i][j] == 1) {
					q.offer(new Pos(i,j));
				}
			}
		}
		System.out.println(bfs());	
	}
	private static int bfs() {
		int max =0;

			while(!q.isEmpty()) {
				Pos temp = q.poll();
				for(int k =0; k<4; k++) {
					int ni = temp.row + di[k];
					int nj = temp.col + dj[k];
					if(ni >=0 && ni < N && nj >=0 && nj < M && arr[ni][nj] == 0) {
						arr[ni][nj] = arr[temp.row][temp.col]+1; 
						q.offer(new Pos(ni,nj));
					}
				}
			}

		//토마토 체크
		for(int a = 0; a < N; a++) {
			for(int b = 0; b <M; b++) {
				if(arr[a][b] == 0) {
					return -1;
				}
				max = Math.max(max, arr[a][b]);
			}
		}
		
        if (max == 1) {
            return 0;
        } else { // 아닐 경우 최종날짜 - 1 출력
            return max-1;
        }
	}
}
