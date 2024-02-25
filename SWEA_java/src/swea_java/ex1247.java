package swea_java;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ex1247 {
	static class Pos{
		int row, col;
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	static int n;
	static Pos cust[];
	static boolean visit[];
	static PriorityQueue<Integer> min;
	static Pos end;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1; tc <= TC; tc++) {
			n = sc.nextInt(); // 고객 수
			Pos start = new Pos(sc.nextInt(), sc.nextInt());
			end  = new Pos(sc.nextInt(), sc.nextInt());
			visit = new boolean[n];
			int cnt = 0;
			min = new PriorityQueue<Integer>();
			cust = new Pos[n];
			
			for(int i = 0; i < n; i++) {
				cust[i] = new Pos(sc.nextInt(), sc.nextInt());
			}
			perm(start.row, start.col, cnt, 0);
			System.out.println("#"+tc+" "+ min.poll());
		}
	}
	
	private static void perm(int row, int col, int cnt, int dis) {
		if(cnt == n) {
			int temp = distance(row, col,end.row, end.col );
			min.add(temp+dis);
			return;
		}
		for(int i = 0; i <n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				perm(cust[i].row, cust[i].col, cnt +1, dis + distance(row, col,cust[i].row ,cust[i].col));
				visit[i] = false;
			}
		}
	}
	
	private static int distance(int nowi, int nowj, int nexti, int nextj) {
		return Math.abs(nowi - nexti) + Math.abs(nowj- nextj);
	}
}


