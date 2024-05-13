import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, ans;
	static int [][] board;

	static boolean [] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n+1][n+1];
		ans = Integer.MAX_VALUE;
		visit = new boolean[n+1];
		
		StringTokenizer st;
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(1,0);
		System.out.println(ans);
	}
	static void func(int start, int cnt) {
		if(cnt == n/2) {
			check();
			return;
		}
		else {
			for(int i = start; i <=n; i++) {
				visit[i] = true;
				func(i+1, cnt+1);
				visit[i] = false;
			}
		}
	}
	static void check() {
		int teamA = 0;
		int teamB = 0;
		for(int i  = 1; i < n; i++) {
			for(int j = i +1; j <=n; j++) {
				if(visit[i] == true && visit[j] == true) {
					teamA+= board[i][j] + board[j][i];
				}
				else if(visit[i] == false && visit[j] == false) {
					teamB += board[i][j] + board[j][i];
				}
			}
		}
		int temp = Math.abs(teamA - teamB);
		if(temp == 0) {
			System.out.println(0);
			System.exit(0);
		}
		ans = Math.min(temp, ans);
	}
}