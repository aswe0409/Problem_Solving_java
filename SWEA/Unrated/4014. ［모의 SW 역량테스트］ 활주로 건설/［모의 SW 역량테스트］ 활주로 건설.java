import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,x;
	static int [][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			arr = new int[n*2][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = n, k = 0; i < n*2; i++,k++) {
				for(int j = 0; j <n; j++) {
					arr[i][j] = arr[j][k];
				}
			}
			int ans = 0;
			for(int i = 0; i < n*2; i++) {
				boolean state = search(i);
				if(state == true) {
					ans+=1;
				}
			}
			System.out.println("#"+test+" "+ans);
		}
	}
	static boolean search(int idx) {
		boolean [] visit = new boolean[n];
		for(int i = 0; i <n-1; i++) {
			//1. 모든 줄이 같은지 확인 => 같은 값이면 이미 활주로
			if(arr[idx][i] == arr[idx][i+1]) continue;
			
			//2 나랑 옆에값 차이가 2 이사이면 경사로 설치 불가
			else if(Math.abs(arr[idx][i] - arr[idx][i+1]) >= 2) return false;
			
			//3. 나랑 옆에 값 차이가 1이면 내리막 
			else if(arr[idx][i] - arr[idx][i+1] == 1) {
				for(int j = i+1; j <= i+x; j++) {
					if (j >= n || arr[idx][j] != arr[idx][i + 1] || visit[j]) {
						return false;
					}
					visit[j] = true;
				}
			}
			// 4. 나랑 옆에 값 차이가 -1이면 오르막
			else if(arr[idx][i] - arr[idx][i+1] == -1) {
				for(int j = i; j > i -x; j--) {
					if (j <0 || arr[idx][j] != arr[idx][i] || visit[j]) {
						return false;
					}
					visit[j] = true;
				}
			}	
		}
		return true;
	}
}