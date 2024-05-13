import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, ans;
	static int [][] board;
	static int [] ret;
	static boolean [] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n+1][n+1];
		ans = Integer.MAX_VALUE;
		ret = new int[n/2];
		visit = new boolean[n+1];
		
		StringTokenizer st;
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i = 0; i <= n; i++) {
//			for(int j = 0 ; j <= n; j++) {
//				System.out.print(board[i][j]+" ");
//			}
//			System.out.println();
//		}
		func(1,0);
		System.out.println(ans);
	}
	static void func(int start, int cnt) {
		if(cnt == n/2) {
//			for(int temp : ret) {
//				System.out.print(temp+" ");
//			}
//			System.out.println();
			check();
			return;
		}
		
		else {
			for(int i = start; i <=n; i++) {
				ret[cnt]=i;
				visit[i] = true;
				func(i+1, cnt+1);
				visit[i] = false;
			}
		}
	}
	static void check() {
//		List<Integer> idxb = new ArrayList<Integer>();
//		for(int i = 1; i <=n; i++) {
//			if(visit[i] == false) {
//				idxb.add(i);
//				//System.out.print(i+" ");
//			}
//		}
		//System.out.println();
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
		//System.out.println(temp);
		ans = Math.min(temp, ans);
	}
}