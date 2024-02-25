package baekjoon_java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ex7569 {
	static class Pos{
		int row, col, height;
		public Pos(int height, int row, int col) {
			this.row = row; // 세로
			this.col = col; // 가로
			this.height = height; // 높이
		}
	}
	
	static Queue<Pos> q;
	static int N,M,H; 
	static int [][][] arr;
	static int[] di = {0,-1,0,1,0,0};
	static int[] dj = {1,0,-1,0,0,0};
	static int[] dh = {0,0,0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); //가로
		N = sc.nextInt(); //세로
		H = sc.nextInt(); //높이
		arr = new int[H][N][M];
		q = new LinkedList<>();
		
		for(int k = 0; k < H; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <M; j++) {
					arr[k][i][j] = sc.nextInt();
				}
			}
		}

		for(int k = 0; k < H; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <M; j++) {
					if(arr[k][i][j] == 1) {
						q.offer(new Pos(k,i,j));
					}
				}
			}
		}

		System.out.println(bfs());
	}
	
	private static int bfs() {
		int max =0;
		
		while(!q.isEmpty()) {
			Pos roc = q.poll();
			for(int k = 0; k < 6; k++) {
				int nh = roc.height + dh[k];
				int ni = roc.row + di[k];
				int nj = roc.col + dj[k];
				
				if(nh >=0 && nh < H && ni >=0 && ni < N && nj >=0 && nj < M && arr[nh][ni][nj] == 0) {
					arr[nh][ni][nj] = arr[roc.height][roc.row][roc.col]+1;
					q.offer(new Pos(nh,ni,nj));
				}
			}
		}
		//토마토 체크
		for(int c = 0; c <H; c++) {
			for(int a = 0; a < N; a++) {
				for(int b = 0; b <M; b++) {
					if(arr[c][a][b] == 0) {
						return -1;
					}
					max = Math.max(max, arr[c][a][b]);
				}
			}
		}
        if (max == 1) {
            return 0;
        } else { // 아닐 경우 최종날짜 - 1 출력
            return max-1;
        }

	}

}
