import java.io.*;
import java.util.*;

public class Main {
	static class Pos{
		int row, col,time;
		Pos(int row, int col, int time){
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}
	static int [] di = {-1,1,0,0};
	static int [] dj = {0,0,-1,1};
	static char[][] arr;
	static boolean [][] visited;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		
		int ret = 0;

		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 'L') {
					ret = Math.max(bfs(i, j),ret);
				}
			}
		}
		System.out.println(ret);
	}
	
	 static public int bfs(int nowi, int nowj) {
		visited = new boolean[n][m];
		Queue<Pos> q = new LinkedList<>();
		visited[nowi][nowj] = true;
		q.offer(new Pos(nowi, nowj, 0));
		int maxNum = 0;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			
			maxNum = Math.max(maxNum, temp.time);
			
			for(int d = 0; d < 4; d++) {
				int newi = temp.row + di[d];
				int newj = temp.col + dj[d];
				
				if(newi >= 0 && newi < n && newj >= 0 && newj < m && !visited[newi][newj] && arr[newi][newj] == 'L') {
					visited[newi][newj] = true;
					q.offer(new Pos(newi, newj, temp.time + 1));
				}
			}
		}
		return maxNum;
	 }
}
