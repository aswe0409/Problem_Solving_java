import java.io.*;
import java.util.*;

public class Main {
	static class Pos{
		int height,row, col, cnt;
		public Pos(int height, int row, int col, int cnt) {
			this.height = height;
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	static char [][][] map;
	static boolean [][][] visited;
	static int l,r,c, startl, startr, startc;
	static int [] di = {-1,1,0,0,0,0}; //동 서 남 북 상 하
	static int [] dj = {0,0,1,-1,0,0};
	static int [] dz = {0,0,0,0,1,-1};
	static Queue<Pos> q;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(l == 0 && r == 0 && c == 0) { //모두 0,0,0 이면 종료
				break;
			}
			
			map = new char[l][r][c];
			visited = new boolean[l][r][c];
			q = new LinkedList<Pos>();
			
			for(int i = 0; i < l; i++) {
				for(int j = 0; j < r; j++) {
					String line = br.readLine();
					for(int k = 0; k < c; k++) {
						char temp  = line.charAt(k);
						if(temp == 'S') {
							startl = i;
							startr = j;
							startc = k;
						}
						map[i][j][k] = temp;
					}
				}
				br.readLine();
			}
			
			int cnt = bfs(startl,startr,startc);
			
			if(cnt <0) {
				System.out.println("Trapped!");
			}
			else {
				System.out.println("Escaped in "+ cnt+" minute(s).");
			}
			
		}
	}
	static int bfs(int nowl, int nowr, int nowc) {
		q = new LinkedList<Pos>();
		q.offer(new Pos(nowl, nowr, nowc, 0));
		visited[nowl][nowr][nowc] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			
			for(int d = 0; d < 6; d++) {
				int newl = temp.height + dz[d];
				int newr = temp.row + di[d];
				int newc = temp.col + dj[d];
				
				if(newl >= 0 && newl < l && newr >= 0 && newr < r && newc >= 0 && newc < c && map[newl][newr][newc] == 'E') {
					return temp.cnt +1;
				}
				
				if(newl >= 0 && newl < l && newr >= 0 && newr < r && newc >= 0 && newc < c && !visited[newl][newr][newc] && map[newl][newr][newc] == '.') {
					q.offer(new Pos(newl,newr,newc,temp.cnt+1));
					visited[newl][newr][newc] = true;
				}
			}
		}
		return -1;
	}
}