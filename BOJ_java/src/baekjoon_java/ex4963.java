package baekjoon_java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ex4963 {
	
	static class Pos{
		int row, col;
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static int[][] map;
	static int[] di = {0,-1,0,1,-1,-1,1,1};
	static int[] dj = {1,0,-1,0,1,-1,1,-1};
	static int N, M;
	static Queue<Pos> q; //bfs 담을 배열
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            N = sc.nextInt();
            M = sc.nextInt();
            if(N == 0 && M ==0) break;
            
            int cnt = 0;
            map = new int[M][N]; // 지도

            for(int i = 0; i < M; i++) {
            	for(int j = 0; j <N; j++) {
            		map[i][j] = sc.nextInt();
            	}
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j <N ; j++) {
                	if(map[i][j] == 1) {
                		cnt += 1;
                		bfs(i,j);
                	}
                }
            }
            System.out.println(cnt);
        }
    }
    
    private static void bfs(int i, int j) {
        q = new LinkedList<>();
		q.offer(new Pos(i,j)); //bfs 탐색 출발 좌표를 일단 큐에 방문 스케줄 잡자
		map[i][j] = 0; // 이 정점 방문 스케줄 잡혔음 표시해놓기! 큐에 스케줄 중복해서 들어 갈 수 있음
		
    	if(q.isEmpty()) return ;
    	
    	while(!q.isEmpty()){
    		Pos temp = q.poll();
    		for(int k=0; k<8; k++) {
        		int ni = temp.row + di[k];
        		int nj = temp.col + dj[k];
    			if(ni >=0 && ni <M && nj >=0 && nj <N && map[ni][nj] == 1) {
    				q.offer(new Pos(ni, nj));
    				map[ni][nj] = 0;
    			}
    		}
    	}
    }
    private static void dfs(int i, int j) {
    	map[i][j] = 0;
		for(int k=0; k<8; k++) {
    		int ni = i + di[k];
    		int nj = j + dj[k];
			if(ni >=0 && ni <M && nj >=0 && nj <N && map[ni][nj] == 1) {
				map[ni][nj] = 0;
				dfs(ni, nj);
			}
		}
		return;
    }
}