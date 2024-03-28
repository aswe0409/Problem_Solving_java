import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Water{
		int row, col;
		Water(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	static class Mouse{
		int row, col, cnt;
		Mouse(int row, int col, int cnt){
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
	static Queue<Water> wq;
	static Queue<Mouse> mq;
	static int r,c, status, cnt;
	static char [][] arr;
	static boolean [][] wvisit;
	static boolean [][] mvisit;
	static int []di  = {-1,1,0,0};
	static int [] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		wq = new LinkedList<>();
		mq = new LinkedList<>();
		mvisit = new boolean[r][c];
		wvisit = new boolean[r][c];
		
		for(int i = 0 ;i < r; i++) {
			String line = br.readLine();
			for(int j = 0; j < c; j++) {
				char temp = line.charAt(j);
				arr[i][j] = temp;
				if(arr[i][j] == 'S') {
					mq.offer(new Mouse(i,j,0));
				}
				else if(arr[i][j] == '*') {
					wq.offer(new Water(i,j));
				}
			}
		}
		move();
		if(status == 1) {
			System.out.println(cnt);
		}
		else {
			System.out.println("KAKTUS");
		}
	}
	
	static void move() {
		while(!mq.isEmpty()) {
			waterspread();
			
			int size = mq.size();
			
			for(int i = 0; i < size; i++) {
				Mouse temp = mq.poll();
				mvisit[temp.row][temp.col] = true;
				
				for(int d = 0; d < 4; d++) {
					int newi = temp.row + di[d];
					int newj = temp.col + dj[d];
					if(newi >= 0 && newi < r && newj >= 0 && newj < c && arr[newi][newj] == 'D') {
						status = 1;
						cnt = temp.cnt +1;
						return;
					}
					
					if(newi >= 0 && newi < r && newj >= 0 && newj < c && !mvisit[newi][newj] && arr[newi][newj] == '.') {
						mvisit[newi][newj] = true;
						mq.offer(new Mouse(newi, newj,temp.cnt+1));
						arr[newi][newj] = 'S';
					}
				}
			}
//			for (int i = 0; i < r; i++) {
//				for (int j = 0; j < c; j++) {
//					System.out.print(arr[i][j]+" ");
//					
//				}
//				System.out.println();
//			}
			
		}
		
	}
	
	static void waterspread() {
		int size = wq.size();
		
		for(int i = 0; i < size; i++) {
			Water temp = wq.poll();
			wvisit[temp.row][temp.col] = true;
			
			for(int d = 0; d < 4; d++) {
				int newi = temp.row + di[d];
				int newj = temp.col + dj[d];
				if(newi >= 0 && newi < r && newj >= 0 && newj < c && !wvisit[newi][newj] && arr[newi][newj] != 'D' && arr[newi][newj] != 'X') {
					wvisit[newi][newj] = true;
					wq.offer(new Water(newi, newj));
					arr[newi][newj] = '*';
				}
			}
		}
	}
}