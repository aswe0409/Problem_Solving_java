import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pos{
		int row, col,cnt;
		Pos(int row, int col, int cnt){
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
	static int starti, startj, endi, endj, n;
	static int [][] arr;
	static boolean [][] visit;
	static int [] di = {-2,-2,-1,1,2,2,1,-1};
	static int[] dj = {-1,1,2,2,1,-1,-2,-2};
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int t = 0; t < test; t++) {
			n = sc.nextInt(); // 체스판 크기
			starti = sc.nextInt();
			startj = sc.nextInt();
			endi = sc.nextInt();
			endj = sc.nextInt();
			
			arr = new int[n][n];
			if(starti == endi && startj == endj) {
				System.out.println(0);
			}
			else {
				bfs();
			}
		}
	}
	
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(starti, startj,0));
		visit = new boolean[n][n];
		visit[starti][startj] = true;
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			for(int d = 0; d <8; d++) {
				int newi = cur.row + di[d];
				int newj = cur.col + dj[d];
				
				if(newi == endi && newj ==endj) {
					System.out.println(cur.cnt+1);
					return;
				}
				
				if(newi >= 0 && newi < n && newj >=0 && newj < n && !visit[newi][newj]) {
					q.offer(new Pos(newi, newj, cur.cnt+1));
					visit[newi][newj] = true;
				}
			}
		}
	}
}