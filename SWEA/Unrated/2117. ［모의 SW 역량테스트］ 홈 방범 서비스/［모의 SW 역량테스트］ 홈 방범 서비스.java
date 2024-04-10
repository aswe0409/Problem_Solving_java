import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class Pos{
		int row, col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	static int n,m;
	static int [][]arr;
	static Queue<Pos> q;
	static int []di = {1,-1,0,0};
	static int []dj = {0,0,1,-1};
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <=t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			q = new LinkedList<>();
			ans = Integer.MIN_VALUE;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					bfs(i,j);
				}
			}
			System.out.println("#"+test+" "+ans);
		}
	}
	static void bfs(int nowi, int nowj) {
		boolean [][] visit = new boolean[n][n];
		q.offer(new Pos(nowi, nowj));
		visit[nowi][nowj] = true;
		int k = 1;
		int house = 0;
		while(!q.isEmpty()) {
			
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Pos cur = q.poll();
				if(arr[cur.row][cur.col] ==1) { //해당 위치가 집이면 +1
					house+=1;
				}
				for(int d = 0; d <4; d++) {
					int newi = cur.row + di[d];
					int newj = cur.col + dj[d];
					if(newi>=0 && newi<n && newj>=0 && newj<n && !visit[newi][newj]) {
						q.offer(new Pos(newi, newj));
						visit[newi][newj] = true;
					}
				}
			}
			int cost = k * k + (k - 1) * (k - 1);
			int income = house * m;
			if(cost <= income) {
				ans = Math.max(ans, house);
			}
			k+=1;
		}
	}
}