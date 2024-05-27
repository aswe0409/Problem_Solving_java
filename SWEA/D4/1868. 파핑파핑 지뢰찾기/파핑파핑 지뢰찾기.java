import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static class Pos{
		int row,col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	static char [][] arr;
	static int [][] map;
	static boolean [][] visit;
	static int n;
	static int [] di = {-1,1,0,0,-1,-1,1,1};
	static int [] dj = {0,0,-1,1,-1,1,-1,1};
	static int ans;
	static Queue<Pos> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test<=t; test++) {
			n = Integer.parseInt(br.readLine());
			visit = new boolean[n][n];
			arr = new char[n][n];
			map = new int[n][n];
			ans = 0;
			q = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				String temp = br.readLine();
				for(int j = 0; j < n; j++) {
					arr[i][j] = temp.charAt(j);
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					check(i,j);// 주변 지뢰 몇개인지
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j =0; j < n; j++) {
					 if (map[i][j] == 0 && arr[i][j] == '.' && !visit[i][j]) {
						bfs(i,j);
						ans +=1;
					}
				}
			}
			//bfs로 체크 못 한거것들
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && arr[i][j] == '.') {
                    	visit[i][j] = true;
                        ans+=1;
                    }
                }
            }
			System.out.println("#"+test+" "+ans);
		}
	}
	
	static void check(int nowi, int nowj) {
        if (arr[nowi][nowj] == '*') {
            map[nowi][nowj] = -1; // 지뢰 표시
            return;
        }
		int cnt = 0;
		for(int d = 0; d < 8; d++) {
			int newi = nowi + di[d];
			int newj = nowj + dj[d];
			
			if(newi >= 0 && newi < n && newj >= 0 && newj < n) {
				if(arr[newi][newj] == '*') {
					cnt +=1;
				}
			}
		}
		map[nowi][nowj] = cnt;
	}

	static void bfs(int nowi, int nowj) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(nowi, nowj));
        visit[nowi][nowj] = true;
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for(int d= 0; d<8; d++) {
				int newi = cur.row + di[d];
				int newj = cur.col + dj[d];
				if(newi>= 0&&newi<n && newj>= 0 && newj<n && !visit[newi][newj]&& arr[newi][newj]=='.') {
					visit[newi][newj] = true;
					if(map[newi][newj] == 0) { //0이면 연쇄로 퍼져나가야 하니까 0일때만 q에 넣어줌
						q.offer(new Pos(newi,newj));
					}
				}
			}
		}
	}
}