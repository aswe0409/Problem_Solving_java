package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109_빵집 {
	static int r ,c;
	static int [] di = {-1, 0, 1};
	static int[] dj = { 1, 1, 1 };
	static int cnt = 0;
	static int state;
	static char[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			String line = br.readLine();
			for(int j = 0; j < c; j++) {
				arr[i][j] =line.charAt(j);
			}
		}
		
		for(int i = 0; i < r; i++) {
			if(arr[i][0] == '.') {
				state = 0;
				dfs(i,0);
			}
		}
		System.out.println(cnt);
	}
	
	private static void dfs(int nowi, int nowj) {
		if(nowj == c-1) {//벽에 닿으면
			cnt+=1;
			state = 1;
			return;
		}
		else {
			for(int k = 0; k < 3; k++) {
				int newi = nowi + di[k];
				int newj = nowj + dj[k];
				if (newi >= 0 && newi < r && newj >= 0 && newj < c && arr[newi][newj] == '.') {
					arr[newi][newj] = '1';
					dfs(newi, newj);
					if(state != 1) {
						continue;
					}
					else {
						return;
					}
				}

			}

		}
	}
}
