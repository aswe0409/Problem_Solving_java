import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int [][] arr;
	static boolean [][] visit;
	static int [] di = {-1,1,0,0};
	static int [] dj = {0,0,-1,1};
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visit[i][j] = true;
				dfs(i,j,1,arr[i][j]);
				visit[i][j] = false;
			}
		}
		System.out.println(ans);
	}
	static void dfs(int row, int col, int cnt, int sum) {
		if(cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		else {
			for(int d = 0; d <4; d++) {
				int newi = row + di[d];
				int newj = col + dj[d];
				
				if(newi < 0 || newi >= n || newj < 0|| newj >= m || visit[newi][newj]) {
					continue;
				}
				else {
					
					if(cnt ==2) {
						visit[newi][newj] = true;
						dfs(row, col, cnt+1, sum+arr[newi][newj]);
						visit[newi][newj] = false;
					}
					visit[newi][newj] = true;
					dfs(newi,newj,cnt +1,sum+arr[newi][newj]);
					visit[newi][newj] = false;
				}
			}
		}
	}
}