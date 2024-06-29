import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 물 품수
		int k = Integer.parseInt(st.nextToken()); // 최대 무게
		
		int [] w = new int[n+1];// 무게 담아줄 배열
		int [] v = new int[n+1]; // 가격 담아줄 배열
		int [][] dp = new int[n+1][k+1];
		
		for(int i = 1; i <=n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(str.nextToken());
			v[i] = Integer.parseInt(str.nextToken());
		}
		for(int i = 1; i <=n; i++) {
			for(int j = 1; j<=k; j++) {
				//무게를 안 담을 경우
				if(w[i] > j) { // j: 해당 열에서 담 을 수 있는 최대 값 
					dp[i][j] = dp[i-1][j]; // 이전 값 넣어줌
				}
				else { //무게를 담을 경우
					// 이전값이랑 값을 담은 값중 최대값 을 넣어줌
					// 담았으니까 v[i] 담은 현재 값 + 아직 담 을 수 있는 무게가 남았네?
					// 그럼 그 무게 값 더해 줌 j - w[i] 
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - w[i]] + v[i]); 
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}