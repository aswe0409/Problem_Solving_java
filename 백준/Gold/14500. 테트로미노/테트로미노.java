import java.util.Scanner;

public class Main {
	static int [][] map;
	static boolean [][] visit;
	static int [] di = {-1,1,0,0};
	static int [] dj = {0,0,-1,1};
	static int n,m;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visit[i][j] = true;
				dfs(i,j,1,map[i][j]);
				visit[i][j] = false;
				others(i,j);
			}
		}
		System.out.println(max);
	}
	
	static void dfs(int i , int j, int cnt, int sum) {
		if(cnt >= 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int k = 0; k < 4; k++) {
			int nx = i + di[k];
			int ny = j + dj[k];
			if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;
			if(!visit[nx][ny]) {
				visit[nx][ny] = true;
				dfs(nx, ny,cnt +1, sum + map[nx][ny]);
				visit[nx][ny] = false;
			}
		}
	}
	
	static void others(int i , int j) {
		 if (i+2 < n && j+1 < m)
	            max = Math.max(max, map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j]);
	       if (i+2 < n && j > 0)
	            max = Math.max(max, map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j-1]);
	        if (i+1 < n && j+2 < m)
	            max = Math.max(max, map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1]);
	        if (i+1 < n && j+1 < m && j > 0)
	            max = Math.max(max, map[i][j] + map[i+1][j] + map[i+1][j-1] + map[i+1][j+1]);
	}
}