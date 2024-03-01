package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236_아기상어 {
	static class Shark implements Comparable<Shark>{
		int row, col ,cnt;
		Shark(int row, int col, int cnt){
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Shark o) {
			if(this.row != o.row) {
				return this.row - o.row;
			}
			return this.col - o.col;
			
		}
	}
	
	static int di[] = {-1,0,1,0};
	static int dj[] = {0,-1,0,1};
	static int shark_i, shark_j, shark_size, shark_eat;
	static int ret;
	static int n;
	static int arr[][];
	static boolean visit[][];
	static Queue<Shark> q;
	static int state = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];

		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for(int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = temp;
				if(temp == 9) {
					shark_i = i;
					shark_j = j;
					shark_size = 2;
					shark_eat = 0;
					arr[i][j] = 0;

			}
		}
	}
//		for(int i = 0; i < n; i++) {
//		for(int j = 0; j < n; j++) {
//			
//		}
//	}
			
		while(true) {
			if(!bfs()) break; // 더 먹을게 없대 ㅠㅠ 엄마 ㅠㅠ
		}
		
		System.out.println(ret);

	}
	
	private static boolean bfs() {
		q = new LinkedList<>();
		visit = new boolean[n][n];
		
		q.add(new Shark(shark_i, shark_j, 0));
		visit[shark_i][shark_j] = true;
		
		boolean isEat = false;
		//int dist = 0; // 이동거리
		PriorityQueue<Shark> feed = new PriorityQueue<>();
		while(!q.isEmpty()) {
			int size = q.size(); 
			for(int s = 0; s < size; s++) {
				Shark temp = q.poll();
				
				if(arr[temp.row][temp.col] != 0 && arr[temp.row][temp.col] < shark_size) {
					feed.add(temp);
				} // 같은 거리에 있는 애들 처음에 size 재놓고 그만큼 poll반복  이 중 먹이 있나 볼거임
				
				for(int d = 0; d < 4; d++) {
					int newi = temp.row + di[d];
					int newj = temp.col + dj[d];
					
					if(newi>=0 && newi<n && newj>=0 && newj<n && 
							arr[newi][newj]<=shark_size && !visit[newi][newj]) {
						q.offer(new Shark(newi, newj, temp.cnt +1 ));
						visit[newi][newj] = true;
					}
				}
			}
			
			if(!feed.isEmpty()) {// 오 방금 같은거리 애들 size만큼 poll 하더니 먹이 찾음 ?!
				Shark f = feed.poll();
				shark_eat++;
				arr[f.row][f.col] = 0; //먹음
				shark_i = f.row;
				shark_j = f.col;
				
				if(shark_eat == shark_size) {
					shark_size++;
					shark_eat=0;
				}
				isEat = true;
				ret += f.cnt;  // 방금 먹이먹느라 이동한 칸은 상어 출발할 때 위치로부터 dist 만큼 떨어진 좌표였음! 이동거리 누적!
				break; // while 반복 종료. queue에 좌표 남아있어도 쓸모없음 나 이미 먹이 먹음!
			}
			//dist+=1;
		}
		return isEat;
		
	}
}
