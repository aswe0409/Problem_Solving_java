import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static class Pos{
		int row, col;
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	static int [] di = {1,-1,0,0};
	static int [] dj = {0,0,-1,1};
	static int n;
	static int [][]arr;
	static boolean[][] visited;
	static Queue<Pos> q;
	static List<Integer> sum; // 단지 수 담을 배열
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		q = new LinkedList<>();
		int cnt = 0;//단지수
		visited = new boolean[n][n];
		sum = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 1 & !visited[i][j]) {
					cnt +=1;
					sum.add(bfs(i,j));
				}
			}
		}
		System.out.println(cnt);
		sum.sort(null);
        for(int i = 0; i < sum.size(); i++) {
        	System.out.println(sum.get(i));
        }
	}
	
	private static int bfs(int nowi, int nowj) {
		q.offer(new Pos(nowi, nowj));
		visited[nowi][nowj] = true;
		int temp_cnt = 1;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			for(int k = 0; k < 4; k++) {
				int newi = temp.row + di[k];
				int newj = temp.col + dj[k];
				
				if(newi >=0 && newi < n && newj >= 0 && newj < n && !visited[newi][newj] && arr[newi][newj] == 1) {
					temp_cnt +=1;
					visited[newi][newj] = true;
					q.offer(new Pos(newi, newj));
				}
			}
		}
		return temp_cnt;
	}
}