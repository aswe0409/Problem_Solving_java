import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int K,W,H;
	static int[][] map;
	static boolean[][][] visit; // 어떤 i,j에 스킬을 몇 번 쓰고 왔는지 k가지를 각각 t/f 기록하기 위해
	
	static int [] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	
	static int[] sdi = {-2,-1,1,2,2,1,-1,-2};
	static int[] sdj = {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		
		map = new int[H][W];
		visit = new boolean[H][W][K+1]; // 스킬을 다 썼을 경우 인덱스 K를 써야 함!
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		System.out.println(bfs());
	}
	static int bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(0,0,0));
		visit[0][0][0] = true; //스킬 사용 0회로 출발지에 있음 기록
		
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s< size; s++) {
				Point now = q.poll();
				if(now.i == H-1 && now.j == W-1) {
					return time;
				}
				else {
					for(int d = 0; d< 4; d++) { // 걸어다니는 애들이 다음 시간에 이동가능한 칸 탐색
						int nexti = now.i + di[d];
						int nextj = now.j + dj[d];
						
						//나 지금 걷는 중이라 스킬횟수 증가 없이 그 칸 도착 하는데 그전에 안 지나간거 맞지?
						if(nexti >= 0 && nexti < H && nextj >= 0 && nextj < W && map[nexti][nextj] == 0
								&& !visit[nexti][nextj][now.skill]) {
							visit[nexti][nextj][now.skill] = true;
							q.add(new Point(nexti, nextj, now.skill)); // 스킬횟수 동일
						}
					}
					if(now.skill <= K - 1) {
						for(int d= 0; d< 8; d++) { //이번에는 스킬써서 이동한다면 한시간 뒤에 가게되는 칸 탐색
							int nexti = now.i + sdi[d];
							int nextj = now.j + sdj[d];
							
							if(nexti >= 0 && nexti < H && nextj >= 0 && nextj < W && map[nexti][nextj]== 0
									&& !visit[nexti][nextj][now.skill+1]) {
								visit[nexti][nextj][now.skill+1] = true;
								q.add(new Point(nexti, nextj, now.skill+1));
							}
						}
					}
				
				}
				
			}
			time +=1;
		}
		return -1;
	}
	
	static class Point{
		int i, j, skill;
		public Point(int i, int j, int skill) {
			this.i = i;
			this.j = j;
			this.skill = skill;
		}
	}
}