import java.util.*;
import java.io.*;

public class Main {
	static class Pos{
		int row, col, cnt;
		
		public Pos(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	static int N;
	static int cnt = Integer.MAX_VALUE;
	static int idx = 1;
	static int [][] map;
	static boolean [][] visited, visit;
	static int [] di = {0,0,-1,1};
	static int [] dj = {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 섬 구분하고 
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i,j); 
					idx += 1;
					//printMap();
				}
			}
		}
		//섬끼리 최단거리 구하기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] !=0) {
					distance(i,j,map[i][j]);
				}
			}
		}
		System.out.println(cnt);
	}
	
	static void bfs(int nowi, int nowj) { // 이거로 일단 섬 구분해
		Queue <Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(nowi, nowj));
		map[nowi][nowj] = idx;
		visited[nowi][nowj] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			for(int d = 0; d < 4; d++) {
				int newi = temp.row + di[d];
				int newj = temp.col + dj[d];
				
				if(newi >= 0 && newi < N && newj >= 0 && newj < N && !visited[newi][newj] && map[newi][newj] == 1) {
					q.offer(new Pos(newi, newj));
					map[newi][newj] = idx;
					visited[newi][newj] = true;
				}
			}
		}
	}
	
	static void distance(int nowi, int nowj, int num) {
		Queue <Pos> disQ = new LinkedList<Pos>();
		disQ.offer(new Pos(nowi, nowj,0));
		visit = new boolean[N][N];
		visit[nowi][nowj] = true;
		
		while(!disQ.isEmpty()) {
			Pos temp = disQ.poll();
			for(int d = 0; d < 4; d++) {
				int newi = temp.row + di[d];
				int newj = temp.col + dj[d];
				
				if(newi >= 0 && newi < N && newj >= 0 && newj < N && map[newi][newj] != 0 &&map[newi][newj] != num) { //다른 섬 만나면 종료
					cnt = Math.min(temp.cnt, cnt);
					return;
				}
				else if(newi >= 0 && newi < N && newj >= 0 && newj < N && map[newi][newj] == 0 && !visit[newi][newj]) {
					disQ.offer(new Pos(newi, newj, temp.cnt +1));
					visit[newi][newj] = true;
				}
			}
		}
	}
	
	static void printMap() {
		System.out.println();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}