import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,m;
	static int [][] arr;
	static int tcnt, ans, xcnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			ans = 0;
			
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					xcnt = 0;
					tcnt = 0;
					int temp = 0;
					xcnt += arr[i][j];
					tcnt += arr[i][j];
					tcount(i,j);
					xcount(i,j);
					if(xcnt > tcnt) {
						temp = xcnt;
					}
					else {
						temp = tcnt;
					}
					//System.out.println(cnt);
					ans = Math.max(ans,temp);
				}
			}
			System.out.println("#"+test+" "+ans);
		}
	}
	static void tcount(int row, int col) {
		//위쪽 row - , col
		for(int i = 1; i < m; i++) {
			int temp = row - i;
			if(temp >= 0) {
				tcnt += arr[temp][col];
			}
		}
		
		//아래쪽 row +, col 
		for(int i = 1; i < m; i++) {
			int temp = row + i;
			if(temp < n) {
				tcnt += arr[temp][col];
			}
		}
		
		//왼쪽 row , col -
		for(int i = 1; i <m; i++) {
			int temp = col - i;
			if(temp >= 0) {
				tcnt += arr[row][temp];
			}
		}
		// 오른쪽 row, col +
		for(int i = 1; i < m; i++) {
			int temp = col + i;
			if(temp < n) {
				tcnt += arr[row][temp];
			}
		}
	}
	static void xcount(int row, int col) {
		//왼쪽 위 대각선 row - col -
		for(int i = 1; i <m; i++) {
			int temp_row = row - i;
			int temp_col = col - i;
			
			if(temp_row >= 0 && temp_col >= 0) {
				xcnt += arr[temp_row][temp_col];
			}
		}
		
		//오른쪽 위 대각선 row - col +
		for(int i = 1; i <m; i++) {
			int temp_row = row - i;
			int temp_col = col + i;
			if(temp_row >= 0 && temp_col <n) {
				xcnt += arr[temp_row][temp_col];
			}
		}
		
		//왼쪽 아래 대각선 row + col -
		for(int i = 1; i < m; i++) {
			int temp_row = row + i;
			int temp_col = col - i;
			if(temp_row < n && temp_col >= 0) {
				xcnt += arr[temp_row][temp_col];
			}
		}
		//오른쪽 아래 대각선 row + col +
		for(int i = 1; i < m; i++) {
			int temp_row = row +i;
			int temp_col = col + i;
			if(temp_row <n && temp_col < n) {
				xcnt += arr[temp_row][temp_col];
			}
		}
	}
}