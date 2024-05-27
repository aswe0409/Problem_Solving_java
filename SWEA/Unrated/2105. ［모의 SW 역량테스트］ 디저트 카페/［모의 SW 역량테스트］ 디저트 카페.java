import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] visit;
	static int[][] arr;
	static int n;
	static int[] di = { 1, 1, -1, -1 };
	static int[] dj = { 1, -1, -1, 1 };
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine());
			ans = -1;
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < n-1; i++) {
				for(int j = 0; j < n-1; j++) {
					visit = new boolean[101];
					visit[arr[i][j]] = true;
					dfs(i,j,i,j,0,1);
				}
			}
			 System.out.println("#"+t+" "+ans);
		}
	}
	static void dfs(int nowi, int nowj, int endi, int endj, int dir, int cnt) {
		for(int d = dir; d < 4; d++) {
			int newi = nowi + di[d];
			int newj = nowj + dj[d];
			
			if(newi == endi && newj == endj && d == 3 && cnt >2) {
				ans = Math.max(ans, cnt);
				return;
			}
			if(newi >= 0 && newi < n && newj >= 0 && newj < n && !visit[arr[newi][newj]]) {
				visit[arr[newi][newj]] = true;
				dfs(newi, newj, endi, endj, d,cnt+1);
				visit[arr[newi][newj]] = false;
			}
		}
	}
}