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
	static int [] di = {1,-1,0,0};
	static int [] dj = {0,0,-1,1};
	
	static int r ,c ;
	static int state = 0, cnt = 1; // 0이면 탈출 불가 1이면 탈출
	static char [][] arr;
	static Queue<Pos> jq, fq;
	static boolean [][] jvisit, fvisit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		jq = new LinkedList<>();
		fq = new LinkedList<>();
		jvisit = new boolean[r][c];
		fvisit = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			String line = br.readLine();
			for(int j = 0; j < c; j++) {
				char temp  = line.charAt(j);
				arr[i][j] = temp;
				if(temp == 'J') {
					jq.offer(new Pos(i,j,0));
					jvisit[i][j] = true;
					if(i == 0 || i == r-1 || j == 0 || j == c-1) {
						System.out.println("1");
						return;
					}
				}
				else if(temp == 'F') {
					fq.offer(new Pos(i,j,0));
					fvisit[i][j] = true;
				}
			}
		}
		
		
		move();
		if(state == 1) {
			System.out.println(cnt);
		}
		else {
			System.out.println("IMPOSSIBLE");
		}
	}
	static void move() {
		while(!jq.isEmpty()) {
			fire();
			int size = jq.size();
			
			for(int i = 0; i < size; i++) {
				Pos temp = jq.poll();
				
				for(int d = 0; d <4; d++) {
					int newi = temp.row + di[d];
					int newj = temp.col + dj[d];
					
					if(newi >= 0 && newi < r && newj >= 0 && newj < c&&(newi == 0 || newi == r-1 || newj == 0 || newj == c-1) && !jvisit[newi][newj] && arr[newi][newj] == '.') {
						state = 1;
						cnt = temp.cnt + 2;
						return;
						
					}
					
					if(newi >= 0 && newi < r && newj >= 0 && newj < c  && !jvisit[newi][newj] && arr[newi][newj] =='.') {
						jq.offer(new Pos(newi,newj, temp.cnt+1));
						jvisit[newi][newj] = true;
					}
				}
			}
		}
		return;
	}
	
	static void fire() {
		int size = fq.size();
		
		for(int i = 0; i < size; i++) {
			Pos temp = fq.poll();
			
			for(int d = 0; d < 4; d++) {
				int newi = temp.row + di[d];
				int newj = temp.col + dj[d];
				
				if(newi >= 0 && newi < r && newj >= 0 && newj < c && !fvisit[newi][newj] && arr[newi][newj] !='#') {
					fq.offer(new Pos(newi, newj,0));
					fvisit[newi][newj] = true;
					arr[newi][newj] = 'F';
				}
			}
		}
	}
}