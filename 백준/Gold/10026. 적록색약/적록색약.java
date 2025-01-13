import java.io.*;
import java.util.*;

public class Main {
	static class Pos{
		int row, col;
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static int n;
	static int [][] map;
	static int [][] sickMap;
	static boolean [][] visited;
	static boolean [][] sickVisited;
	static int [] di = {1, -1, 0 ,0};
	static int [] dj = {0, 0 ,-1, 1};
	static Queue<Pos> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		sickMap = new int[n][n];
		visited = new boolean[n][n];
		sickVisited = new boolean[n][n];
		int cnt = 0, sickCnt = 0;
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				char temp = str.charAt(j);
				if(temp == 'R') {
					map[i][j] = 1;
					sickMap[i][j] = 1;
				}
				else if (temp == 'G') {
					map[i][j] = 2;
					sickMap[i][j] = 1;
				}
				else if(temp =='B') {
					map[i][j] = 3;
					sickMap[i][j] = 3;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					cnt +=1;
					bfs(i,j, map[i][j]);
				}
				if(!sickVisited[i][j]) {
					sickCnt +=1;
					sickBfs(i,j, sickMap[i][j]);
				}
			}
		}
		
		System.out.println(cnt+ " " + sickCnt);
	}
	
	static void bfs(int nowi, int nowj, int target) {
		q = new LinkedList<Pos>();
		q.offer(new Pos(nowi, nowj));
		visited[nowi][nowj] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int newi = temp.row + di[d];
				int newj = temp.col + dj[d];
				
				if(newi >= 0 && newi < n && newj >= 0 && newj < n && !visited[newi][newj]&& target == map[newi][newj]) {
					q.offer(new Pos(newi,newj));
					visited[newi][newj] = true;
				}
			}
		}
	}
	
	static void sickBfs(int nowi, int nowj, int target) {
		q = new LinkedList<Pos>();
		q.offer(new Pos(nowi, nowj));
		sickVisited[nowi][nowj] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int newi = temp.row + di[d];
				int newj = temp.col + dj[d];
				
				if(newi >= 0 && newi < n && newj >= 0 && newj < n && !sickVisited[newi][newj] && target == sickMap[newi][newj] ) {
					q.offer(new Pos(newi,newj));
					sickVisited[newi][newj] = true;
				}
			}
		}
	}
}