package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1600_말이되고픈원숭이 {
	static int [] horse_di = {-2,-2,-1,1,2,2,1,-1};
	static int[] horse_dj = {-1,1,2,2,1,-1,-2,-2};
	
	static int w; // 가로
	static int h; // 세로
	static int [][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h][w];
		
		for(int i = 0; i < h; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		
		
	}
}
