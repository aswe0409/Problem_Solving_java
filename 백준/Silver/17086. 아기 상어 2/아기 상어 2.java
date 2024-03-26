import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos{
		int row, col, cnt;
		Pos(int row, int col, int cnt){
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
	static int n,m;
	static int [][] arr;
	static int []di = {-1,1,0,0,-1,-1,1,1};
	static int []dj = {0,0,-1,1,1,-1,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		
		for(int i = 0; i<n; i++) {
			String line = br.readLine();
			for(int j = 0; j < m*2; j+=2) {
				arr[i][j/2] = line.charAt(j) - '0';
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < m; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		int max = 0;

		for(int i = 0; i<n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					int temp = bfs(i,j);
					if(temp > max) {
						max = temp;
					}
				}
			}
		}
		System.out.println(max);
	}
	
	private static int bfs(int nowi, int nowj) {
		Queue<Pos> q = new LinkedList<>();
		boolean [][] visit = new boolean[n][m];
		visit[nowi][nowj] = true;
		q.offer(new Pos(nowi, nowj, 0));
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			for(int d = 0; d < 8; d++) {
				int newi = temp.row + di[d];
				int newj = temp.col + dj[d];
				if(newi >= 0 && newi < n && newj >= 0 && newj < m &&arr[newi][newj] == 1 && !visit[newi][newj]) {
					return temp.cnt+1;
				}
				if(newi >= 0 && newi < n && newj >= 0 && newj < m && arr[newi][newj] == 0  && !visit[newi][newj]) {
					q.offer(new Pos(newi,newj,temp.cnt+1));
					visit[newi][newj] = true;
				}
			}
		}
		return 0;
	}
}