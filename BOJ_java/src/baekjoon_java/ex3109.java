package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex3109 {

	static char[][] map;
	static int [] di = {-1, 0, 1};
	static int[] dj = { 1, 1, 1 };
	static int C;
	static int R;
	static int cnt = 0;
	static int state;
	static int depth ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			if (map[i][0] == '.') {
				dfs(i, 0);
			}
		}

		System.out.println(cnt);
	}

	private static boolean dfs(int row, int col) {
	    if (col == C - 1) { // 마지막 열에 도착하면 return
	        cnt++;
	        return true; // 성공적인 경로 찾음
	    }

	    for (int k = 0; k < 3; k++) {
	        int ni = row + di[k];
	        int nj = col + dj[k];
	        if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] == '.') {
	            map[ni][nj] = '1'; 
	            if (dfs(ni, nj)) {
	                return true; // 이 경로가 성공적으로 마지막 열에 도달함
	            }
	        }
	    }
	    return false; // 못 찾음
	}
}