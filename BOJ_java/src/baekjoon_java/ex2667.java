package baekjoon_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ex2667 {
	
	static class Pos{
		int row, col;
		public Pos(int col, int row) {
			this.row = row;
			this.col = col;
		}
	}
	static char[][] map;
	static int[] di = {0,0,-1,1}; // 상 하 좌 우
	static int[] dj = {-1,1,0,0};
	static int N;
	static Queue<Pos> q; //bfs 담을 배열
	static List<Integer> sum; // 단지 개수 담을 배열
	static  int temp_sum;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int cnt = 0; // 단지 수
        sc.nextLine(); // 개행 문자 소비
        
        map = new char[N][]; // 지도

        sum = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            map[i] = str.toCharArray(); // 문자열을 문자 배열로 변환하여 map[i]에 저장
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            	if(map[i][j] == '1') {
            		cnt += 1;
            		//sum.add(bfs(i,j));
            		temp_sum= 0;
            		sum.add(dfs(i,j));
            	}
            }
        }
        
        System.out.println(cnt);
        sum.sort(null);
        for(int i = 0; i < sum.size(); i++) {
        	System.out.println(sum.get(i));
        }
    }
    
    private static int bfs(int i, int j) {
        q = new LinkedList<>();
		q.offer(new Pos(i,j)); //bfs 탐색 출발 좌표를 일단 큐에 방문 스케줄 잡자
		map[i][j] = '0'; // 이 정점 방문 스케줄 잡혔음 표시해놓기! 큐에 스케줄 중복해서 들어 갈 수 있음
		temp_sum = 1;
		
    	if(q.isEmpty()) return 0;
    	
    	while(!q.isEmpty()){
    		Pos temp = q.poll();
    		for(int k=0; k<4; k++) {
        		int ni = temp.col + di[k];
        		int nj = temp.row + dj[k];
    			if(ni >=0 && ni <N && nj >=0 && nj <N && map[ni][nj] == '1') {
    				q.offer(new Pos(ni, nj));
    				map[ni][nj] = '0';
    				temp_sum++;
    			}
    		}
    	}
    	return temp_sum;
    	
    }
    
    private static int dfs(int i, int j) {
    	map[i][j] = '0';
    	temp_sum +=1;
    	
		for(int k=0; k<4; k++) {
    		int ni = i + di[k];
    		int nj = j + dj[k];
			if(ni >=0 && ni <N && nj >=0 && nj <N && map[ni][nj] == '1') {
				map[ni][nj] = '0';
				dfs(ni,nj);
			}
		}
		return temp_sum;
    }
}
