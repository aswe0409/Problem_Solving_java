package baekjoon_java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2636_치즈 {
	static class Pos{
		int row, col, hour;
		public Pos(int row, int col, int hour) {
			this.row = row;
			this.col = col;
			this.hour = hour;
		}
	}
	
	static int n; // 세로
	static int m; // 가로
	static int[][] arr;
	static Queue<Pos> q;
	static int[] di = {0,-1,0,1};
	static int[] dj = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 세로
		m = sc.nextInt(); // 가로
		
		arr = new int[n][m];
		q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <m; j++) {
				if(arr[i][j] == 1) {

				}
			}
		}

	}
	
}


