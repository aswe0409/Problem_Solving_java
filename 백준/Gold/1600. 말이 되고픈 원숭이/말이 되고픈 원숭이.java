import java.io.*;
import java.util.*;

public class Main {
	static class Pos{
		int row, col, skill, time;
		
		public Pos(int row, int col, int skill, int time) {
			this.row = row;
			this.col = col;
			this.skill = skill; //스킬 사용 횟수
			this.time = time; // 걸린 시간
		}
	}
	
	static int [][] map;
	static boolean [][][] visited;
	static int K, W, H;
	static Queue <Pos> q;
	static int [] di = {0,0,-1,1};
	static int [] dj = {1,-1,0,0};
	static int [] hdi = {-2,-1,1,2,2,1,-1,-2};
	static int [] hdj = {1,2,2,1,-1,-2,-2,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean [H][W][K+1];
		q = new LinkedList<Pos>();
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		System.out.println(bfs());
	}
	
	static int bfs() {
		q.offer(new Pos(0,0,0,0));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			
			if(temp.row == H-1 && temp.col == W-1) {
				return temp.time;
			}
			
			// 스킬 이동
			if(temp.skill < K) {
				for(int d = 0; d < 8; d++) {
					int newi = temp.row + hdi[d];
					int newj = temp.col + hdj[d];
					if(newi>= 0 && newi < H && newj >= 0 && newj < W && map[newi][newj] == 0 && !visited[newi][newj][temp.skill+1]) {
						q.offer(new Pos(newi, newj, temp.skill +1, temp.time+1));
						visited[newi][newj][temp.skill+1] = true;
					}
				}
			}
			
			// 도보 이동
			for(int d = 0; d < 4; d++) {
				int newi = temp.row + di[d];
				int newj = temp.col + dj[d];
				if(newi>= 0 && newi < H && newj >= 0 && newj < W && map[newi][newj] == 0 && !visited[newi][newj][temp.skill]) {	
					q.offer(new Pos(newi, newj, temp.skill, temp.time+1));
					visited[newi][newj][temp.skill] = true;
				}
			}
		}
		return -1;
	}
}