import java.io.*;
import java.util.*;

public class Main {
	static class Pos{
		int row, col, skill,cnt;
		Pos(int row, int col, int skill, int cnt){
			this.row = row;
			this.col = col;
			this.skill = skill;
			this.cnt = cnt;
		}
	}
	
	static int N,M;
	static int [][] map;
	static boolean [][][] visited;
	
	static int [] di = {0,0,-1,1};
	static int [] dj = {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j)- '0';
			}
		}
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue <Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(0,0,0,0));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			
			if(temp.row == N-1 && temp.col == M -1) {
				return temp.cnt + 1; 
			}
			
			for(int d = 0; d < 4; d++) {
				int newi = temp.row + di[d];
				int newj = temp.col + dj[d];
				
				if(newi >= 0 && newi < N && newj >= 0 && newj < M) {
					//벽 부시고 이동 가능
					if(temp.skill == 0) {
						if(!visited[newi][newj][1]) {
							visited[newi][newj][1] = true;
							q.offer(new Pos(newi, newj, 1, temp.cnt +1));
						}
					}
					// 그낭 이동
					if(!visited[newi][newj][temp.skill] && map[newi][newj] == 0) {
						q.offer(new Pos(newi, newj, temp.skill, temp.cnt +1));
						visited[newi][newj][temp.skill] = true;
					}
				}
			}
		}
		return -1;
	}
}