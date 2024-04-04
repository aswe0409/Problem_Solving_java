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
			
			arr = new int[n*2][n]; // 가로 늘려주는 이유는 가로만 판별 할 거라 세로 값 가로로 바꿀 거임
			
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
			int cnt = 0;
			for(int i = 0; i < n*2; i++) {
				boolean state = search(i); //경사로 탐색할 인덱스 넘겨 주기
				if(state == true) {
					cnt+=1;
				}
			}	
			System.out.println("#"+test+" "+cnt);
		}
	}
	static boolean search(int idx) {
		boolean[] visit = new boolean[n];
		for(int i = 0; i < n-1; i++) {
			//1. 모든 줄이 같은 값인지 확인 할거임 => 만약 같은 값이면 해당 줄은 활주로
			if(arr[idx][i] == arr[idx][i+1]) continue;
			
			//2. 나랑 옆에 값 차이가 2이상이면 return => 경사로 설치할 수가 없어
			else if(Math.abs(arr[idx][i] - arr[idx][i+1]) >=2) return false;
			
			//3. 나랑 옆에 값 차이가 1 이면 내리막 경사로
			else if(arr[idx][i] - arr[idx][i+1] ==1) { //만약에 1이면 경사로 설치 할 수 있는지 check
				//내 위치 부터 내 위치 + x 까지 탐색 해서 만약에 길이 x면 경사로 설치 가능
				for(int j = i+1; j <= i+x; j++) {
					if (j >= n || arr[idx][j] != arr[idx][i + 1] || visit[j]) {
						return false;
					}
                    visit[j] = true;
                }
			}
			//4. 나랑 옆에 값 차이가 -1 이면 오르막 경사로
			else if(arr[idx][i] - arr[idx][i+1] == -1) {
				// 내 위치 부터 반대로 x 까지 탐색 해야 함
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