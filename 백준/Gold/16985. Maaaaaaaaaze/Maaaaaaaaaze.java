import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//1. 순열로 큐브 쌓아 -> 2. 돌려 -> 3. 탐색
public class Main {
	static int [][][] arr, copy_arr;
	static boolean []select; // 회전 해야 할 큐브 선택
	static int [] order; // 쌓은 순서 담을 배열
	static int [] turn; //각 층미다 얼만큼 돌릴지 정할 함수 0= 0도 1= 90도, 2면 180도 3 = 270 
	static int [] di = {1,-1,0,0,0,0};
	static int [] dj = {0,0,-1,1,0,0};
	static int [] dz = {0,0,0,0,-1,1};
	static int ans = Integer.MAX_VALUE;
	static class Pos{
		int row, col, height, cnt;
		Pos(int row, int col, int height, int cnt){
			this.row = row;
			this.col = col;
			this.height = height;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[5][5][5];
		select = new boolean[5];
		order = new int[5];
		turn = new int[5];
		StringTokenizer st;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < 5; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		perm(0);// 1. 순열로 큐브 쌓아
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}
	
	static void perm(int cnt) { //순열로 큐브 쌓는 순서 정함
		if(cnt == 5) {
			for(int i = 0; i < 5; i++) {
				rotate(0); //회전
			}
			return;
		}
		
		for(int i = 0; i < 5; i++) {
			if(!select[i]) {
				select[i] = true;
				order[cnt]= i;
				perm(cnt+1);
				select[i] = false;
			}
		}
	}
	
	static void rotate(int cnt) { // 회전 할거 정함
		if(cnt == 5) {
			doRotate();
			if(copy_arr[0][0][0] == 1 && copy_arr[4][4][4] == 1) {
				bfs();
			}
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			turn[cnt] = i;
			rotate(cnt+1);
		}
	}
	
	
	static void doRotate() { // 회전 수행 함수
		copy_arr = new int[5][5][5];
		
		for(int i = 0; i < 5; i++) {
			int floor = order[i];
			int dir = turn[floor];
			for(int j = 0; j <5; j++) {
				for(int k = 0; k <5; k++) {
					switch (dir) {
					case 0: // 0도 회전
						copy_arr[i][j][k] = arr[floor][j][k];
						break;
					case 1: // 90도 회전
						copy_arr[i][k][4-j] = arr[floor][j][k];
						break;
					case 2: // 180도 회전
						copy_arr[i][4-j][4-k] = arr[floor][j][k];
						break;
					case 3:	 //270도 회전
						copy_arr[i][4-k][j] = arr[floor][j][k];
						break;
					}
				}
			}
		}
	}
	
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		boolean [][][] visit = new boolean[5][5][5];
		q.add(new Pos(0,0,0,0)); //처음 출발지는 0 0 0
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(cur.row == 4 && cur.col == 4 && cur.height ==4) { //도착
				ans = Math.min(ans, cur.cnt);
				break;
			}
			else {
				for(int d = 0; d <6; d++) {
					int newi = cur.row + di[d];
					int newj = cur.col + dj[d];
					int newz = cur.height + dz[d];
					
					if(newi >= 0 && newi <5 && newj >= 0 && newj <5 && newz >=0 
							&& newz <5 && !visit[newi][newj][newz] && copy_arr[newi][newj][newz] == 1) {
						q.add(new Pos(newi,newj,newz,cur.cnt+1));
						visit[newi][newj][newz] = true;
					}
				}
			}
		}
	}
}