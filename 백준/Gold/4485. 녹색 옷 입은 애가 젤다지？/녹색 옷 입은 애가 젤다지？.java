import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int [][]arr; //가중치 담아줄 배열
	static int n;
	static int [] di = {-1,1,0,0};
	static int [] dj = {0,0,-1,1};
	
	static class Pos implements Comparable<Pos>{
		int row, col, cnt;
		Pos(int row, int col, int cnt){
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Pos o) {
			return Integer.compare(cnt, o.cnt);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(true) {
			n = sc.nextInt();
			if(n == 0) {
				break;
			}
			arr = new int[n][n];
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int temp = bfs();
			System.out.println("Problem "+t+": "+temp);
			t+=1;
		}
		
	}
	
	static int bfs() {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		boolean [][] visit = new boolean[n][n];
		
		pq.offer(new Pos(0,0,arr[0][0]));
		visit[0][0] = true;
		
		while(!pq.isEmpty()) {
			Pos temp = pq.poll();
			
			for(int d = 0; d < 4; d++) {
				int newi = temp.row + di[d];
				int newj = temp.col + dj[d];
				
				if(newi == n-1 && newj == n-1) {
					return temp.cnt+ arr[newi][newj];
				}
				if(newi >= 0 && newi <n && newj >= 0 && newj <n && !visit[newi][newj]) {
					visit[newi][newj] = true;
					pq.offer(new Pos(newi, newj, temp.cnt+ arr[newi][newj]));
				}
			}
			
		}
		return 0;
	}
}