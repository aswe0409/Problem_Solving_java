import java.io.*;
import java.util.*;

public class Main {
	static class Pos{
		int row, col, cnt;
		public Pos(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	static int starti, startj, endi, endj,n;
	static Queue<Pos> q;
	static int [][] map;
	static int [] di = {-2, -1, 1, 2, -2, -1, 1, 2};
	static int [] dj = {-1, -2, -2, -1, 1, 2, 2, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int test = 0; test < tc; test++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			visited = new boolean[n][n];
			
			st = new StringTokenizer(br.readLine());
			starti = Integer.parseInt(st.nextToken());
			startj = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			endi = Integer.parseInt(st.nextToken());
			endj = Integer.parseInt(st.nextToken());
			
			if(starti == endi && startj == endj) {
				System.out.println(0);
			}
			else {
				System.out.println(bfs(starti, startj));
			}
		}
	}
	static int bfs(int nowi, int nowj) {
		q = new LinkedList<Pos>();
		q.offer(new Pos(nowi, nowj, 0));
		visited[nowi][nowj] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			for(int d = 0; d < 8; d++) {
				int newi = temp.row + di[d];
				int newj = temp.col + dj[d];
				
				if(newi == endi && newj == endj) {
					return temp.cnt+1;
				}
				
				if(newi >= 0 && newi < n && newj >= 0 && newj < n && !visited[newi][newj]) {
					q.offer(new Pos(newi, newj, temp.cnt +1));
					visited[newi][newj] = true;
				}
			}
		}
		return 0;
	}
}