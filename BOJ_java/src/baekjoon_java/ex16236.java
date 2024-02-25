package baekjoon_java;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ex16236 {
	static class Pos{
		int row, col, eat;
		public Pos(int row, int col, int eat) {
			this.row = row; // i
			this.col = col; // j
			this.eat = eat; // 먹은 양
		}
	}
	static int size = 2; // 상어 크기
	static int can_eat = 0;
	static int[] di = {0,-1,0,1}; //왼쪽부터
	static int[] dj = {-1,0,1,0};// 좌 상 우 하
	static int N;
	static int arr[][];
	static Queue<Pos> q = new ArrayDeque<Pos>();
	static int time = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int cnt = 0; // 입력 받을 때 먹을수 있는 물고기 count
		arr = new int[N][N];
		q = new ArrayDeque<Pos>();
		
        int sharkRow = 0, sharkCol = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1) cnt +=1;
                if (arr[i][j] == 9) {
                    sharkRow = i;
                    sharkCol = j;
                    arr[i][j] = 0; // 상어 위치 초기화
                }
            }
        }
        
		if(cnt == 0) { // 처음에 먹을수 있는게 없으면 종료
			System.out.println(0);
			return ;
		}
		
		System.out.println(time);
	}
	
	private static void bfs(int nowi, int nowj, int now_size, int now_eat) {
		
		
		if(q.isEmpty()) return;
		
		else {
			while(!q.isEmpty()|| can_eat != 0) {
				Pos temp = q.poll();
				for(int k = 0; k < 4; k++) {
					int nexti = temp.row +di[k] ;
					int nextj = temp.col + dj[k];
				
					
					if(nexti >= 0 && nexti < N && nextj >=0 && nextj < N && arr[nexti][nextj] <= temp.size) {
						if(arr[nexti][nextj] == temp.size) { //아기상어 크기랑 물고기랑 크기가 같은경우
							ret +=1;
							q.offer(new Pos(nexti, nextj, temp.size, temp.eat));
						}
						else { //아기 상어 크기랑 물고기 크기가 작은 경우
							ret +=1;
							arr[nexti][nextj] = 0;
							can_eat -=1;
							temp.eat +=1;
							if(temp.eat == temp.size) {
								temp.size+=1;
								temp.eat = 0;
							}
							q.offer(new Pos(nexti, nextj, temp.size, temp.eat));
						}
					}
					
				}
			}
		}
	}
}
