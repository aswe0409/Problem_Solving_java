package baekjoon_java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ex14502 {
	static class Pos{
		int row, col;
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int N; // 세로
	static int M; // 가로
	public static int[] di = { 1, -1, 0, 0 };
	public static int[] dj = { 0, 0, 1, -1 };
	static int[][] arr; // 원본 배열
	static int[][] temp_arr; // 값 바꿀 배열
	static Queue<Pos> q;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt(); // 가로
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		search(0); // 벽 개수 매개변수로
		System.out.println(max);

	}

	// 벽 세우기 벽 3개면 return
	private static void search(int wall) {
		if (wall == 3) {
			bfs();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					search(wall + 1);
					arr[i][j] = 0; // 원상 복구
				}
			}
		}
	}

	private static void bfs() {
		q = new LinkedList<>();
		// 배열 복사
		temp_arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			temp_arr[i] = arr[i].clone();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp_arr[i][j] == 2) { // 2 인 것을 찾아서 주변 2로 바꿈
					q.offer(new Pos(i, j));
				}
			}
		}

		if (q.isEmpty())
			return;

		while (!q.isEmpty()) {
			Pos temp = q.poll();

			for (int k = 0; k < 4; k++) {
				int ni = temp.row + di[k];
				int nj = temp.col + dj[k];

				if (ni >= 0 && ni < N && nj >= 0 && nj < M && temp_arr[ni][nj] == 0) {
					temp_arr[ni][nj] = 2;
					q.offer(new Pos(ni, nj));
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp_arr[i][j] == 0) {
					cnt += 1;
				}
			}
		}
		max = Math.max(max, cnt);
	}
}
