import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos{
		int row, col, skill;
		Pos(int row, int col, int skill){
			this.row = row;
			this.col = col;
			this.skill = skill;
		}
	}
	static int k,w,h;
	static int [][] map;
	static boolean [][][] visit;
	
	static int [] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static int[] sdi = {-2,-1,1,2,2,1,-1,-2};
	static int[] sdj = {1,2,2,1,-1,-2,-2,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		visit = new boolean[h][w][k+1];
		
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0,0,0));
		visit[0][0][0] =true;
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Pos cur = q.poll();
				if(cur.row == h-1 && cur.col == w-1) { //도착
					return time;
				}
				else {//스킬 안 쓰고 지나가는 경우 
					for(int d= 0; d < 4; d++) {
						int newi = cur.row + di[d];
						int newj = cur.col + dj[d];
						if(newi >= 0 && newi < h && newj >= 0 && newj < w && map[newi][newj] == 0
								&& !visit[newi][newj][cur.skill]) {
							visit[newi][newj][cur.skill] = true;
							q.offer(new Pos(newi, newj, cur.skill)); // 스킬 아직 안 썻기 때문에 스킬 횟수 동일
						}
					}
					// 스킬 써서 이동
					if(cur.skill <= k -1) {
						for(int d = 0; d <8; d++) {
							int newi = cur.row + sdi[d];
							int newj = cur.col + sdj[d];
							if(newi >= 0 && newi < h && newj >= 0 && newj < w && map[newi][newj] == 0
									&& !visit[newi][newj][cur.skill+1]) {
								visit[newi][newj][cur.skill+1] = true;
								q.offer(new Pos(newi, newj, cur.skill+1));
							}
						}
					}
				}
			}
			time +=1;
		}
		return -1;
	}
}