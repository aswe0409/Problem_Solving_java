import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos{
		int row, col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	static int max = 0;
	
	static int di[] = {1,-1,0,0};
	static int dj[] = {0,0,-1,1};
	static int n,m;
	static int arr[][];
	static int[][] temp_arr; // 값 바꿀 배열
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		func(0);
		System.out.println(max);
	}
	
	private static void func(int cnt) {
		if(cnt == 3) { //종료 조건
			bfs();
			return;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <m; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					func(cnt + 1);
					arr[i][j] = 0; //원상 복구
				}
			}
		}
	}
	
	private static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		
		temp_arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			temp_arr[i] = arr[i].clone();
		}
		
		//바이러스 퍼트리기
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(temp_arr[i][j] == 2) {
					q.offer(new Pos(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			
			for(int k = 0; k < 4; k++) {
				int newi = temp.row + di[k];
				int newj = temp.col + dj[k];
				
				if(newi >= 0 && newi < n && newj >= 0 && newj < m && temp_arr[newi][newj] == 0) {
					temp_arr[newi][newj] = 2;
					q.offer(new Pos(newi, newj));
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp_arr[i][j] == 0) {
					cnt += 1;
				}
			}
		}
		max = Math.max(max, cnt);
	}
}