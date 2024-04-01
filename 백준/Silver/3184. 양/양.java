import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos{
		int row, col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	static int sheep = 0, wolf= 0;
	static char [][] arr;
	static int [] di = {-1,1,0,0};
	static int [] dj = {0,0,-1,1};
	static int r ,c;
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		visit = new boolean[r][c];
		for(int i = 0; i < r; i++) {
			String line = br.readLine();
			for(int j = 0; j < c; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(!visit[i][j] && (arr[i][j] == 'v' || arr[i][j] =='o')) {
					visit[i][j] = true;
					bfs(i,j);
				}
			}
		}
		System.out.println(sheep+" "+wolf);
	}
	
	static void bfs(int nowi, int nowj) {
		Queue<Pos> q = new LinkedList<>();
		int scnt = 0, wcnt =0;
		q.offer(new Pos(nowi, nowj));
		if(arr[nowi][nowj] == 'v') {
			wcnt +=1;
		}
		else if(arr[nowi][nowj] == 'o') {
			scnt+=1;
		}

		while(!q.isEmpty()) {
			Pos temp = q.poll();
			for(int d = 0; d <4; d++) {
				int newi = temp.row + di[d];
				int newj = temp.col + dj[d];
				
				if(newi >= 0 && newi < r && newj >= 0 && newj < c && !visit[newi][newj] &&arr[newi][newj] != '#') {
					if(arr[newi][newj] == 'v') { // 늑대 만나면 늑대 +1
						wcnt +=1;
					}
					else if(arr[newi][newj] == 'o') { // 양 만나면 양 +1
						scnt +=1;
					}
					visit[newi][newj] = true;
					q.offer(new Pos(newi, newj));
				}
			}
		}
		
		if(scnt > wcnt) {
			sheep += scnt;
		}
		else {
			wolf += wcnt;
		}
	}
}