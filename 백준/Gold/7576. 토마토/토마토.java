import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos{
		int row, col, day;
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	static int di[] = {1,-1,0,0};
	static int dj[] = {0,0,-1,1};
	static int m; //가로
	static int n; // 세로
	static int [][]arr;
	static Queue<Pos> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken()); // 기로
		n = Integer.parseInt(st.nextToken()); // 세로
		arr = new int[n][m];
		q = new LinkedList<>();
		int ret = 0;
		for(int i =0; i < n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 1) {
					q.offer(new Pos(i,j));
			}
		}
		}
		System.out.println(bfs());
	}
	private static int bfs() {

		
		int max = 0;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			for(int k = 0; k < 4; k++) {
				int newi = temp.row + di[k];
				int newj = temp.col + dj[k];
				
				if(newi>= 0 && newi< n && newj >= 0 && newj < m
						&& arr[newi][newj] == 0) {
					arr[newi][newj] = arr[temp.row][temp.col] +1;
					q.offer(new Pos(newi, newj));
					
				}
//				for(int i = 0; i < n; i++) {
//					for(int j = 0; j <m; j++) {
//						System.out.print(arr[i][j]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
		}
		//토마토 체크
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					return -1;
				}
				max = Math.max(max, arr[i][j]);
			}
		}
		return max-1;
	}
}