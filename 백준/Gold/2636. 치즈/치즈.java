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
	
	static int N, M;
	static int[][] arr;
	static int time, last; // 다녹는데 걸리 시간. 다 녹기 직전 마지막 치즈 수
	
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		time = 0;
		
		while(true) {
			if(count() == 0) break;
			last = count();
			bfs();
			melt();
			time +=1;
		}
		System.out.println(time);
		System.out.println(last);
	}
	
	private static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		q.offer(new Pos(0,0));
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			
			for(int k = 0; k < 4; k++) {
				int newi = temp.row + di[k];
				int newj = temp.col + dj[k];
				
				if(newi >= 0 && newi < N && newj >= 0 && newj < M && arr[newi][newj] == 0 && !visit[newi][newj]) {
					visit[newi][newj] = true;
					q.offer(new Pos(newi, newj));
				}
				else if(newi >= 0 && newi < N && newj >= 0 && newj < M && arr[newi][newj] == 1 && !visit[newi][newj]) {
					arr[newi][newj] = 2;
				}
				
			}
		}
	}
	
	private static void melt() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==2) arr[i][j]=0;
			}
		}
	}
	
	
	static int count() { // 치즈 개수 세기
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==1) cnt++;
			}
		}
		return cnt;
	}
}