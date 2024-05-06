import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static class Pos{
		int row, col, cnt;
		
		Pos(int row, int col, int cnt){
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
    static int[] di = { 1, -1, 0, 0 };
    static int[] dj = { 0, 0, -1, 1 };
    static int[][] arr;
    static int n;
    static Queue<Pos> q;
    static boolean[][] visit;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            n = sc.nextInt();
            arr = new int[n][n];
            q = new LinkedList<>();
            visit = new boolean[n][n];

            // map 입력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            // 출발지 도착지 입력
            int starti = sc.nextInt();
            int startj = sc.nextInt();
            arr[starti][startj] = 3; // 시작지는 3으로 표시
            int endi = sc.nextInt();
            int endj = sc.nextInt();
            arr[endi][endj] = 4; // 도착지는 4로 표시
            int ret = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 3) {
                        ret = bfs(i, j);
                    }
                }
            }
            System.out.println("#" + test + " " + ret);
        }
    }
	static int bfs(int nowi, int nowj) {
		q.offer(new Pos(nowi, nowj, 0));
		visit[nowi][nowj] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				Pos cur = q.poll();
				
				for(int d =0; d <4; d++) {
					int newi = cur.row + di[d];
					int newj = cur.col + dj[d];
					
					if (newi >= 0 && newi < n && newj >= 0 && newj < n  &&!visit[newi][newj] && arr[newi][newj] != 1) {
						if(arr[newi][newj] == 2) { //소용 돌이 일때
							if(cur.cnt % 3 ==2) { //다음 칸으로 출발
								q.offer(new Pos (newi, newj, cur.cnt+1));
								visit[newi][newj] = true;
							}
							else { //다음 칸으로 못가면 그자리에 남아 있기
								q.offer(new Pos(cur.row, cur.col, cur.cnt+1));
							}
						}
						else if(arr[newi][newj] == 0){ //소용 돌이가 아닐 때
							q.offer(new Pos(newi, newj, cur.cnt + 1));
                            visit[newi][newj] = true;
						}
					}
					// 다음 칸이 도착 일 때
					if(newi >=0 && newi < n && newj >= 0 && newj <n &&!visit[newi][newj] && arr[newi][newj] == 4) {
						return cur.cnt+1;
					}
				}
			}
		}
		return -1;
	}
}