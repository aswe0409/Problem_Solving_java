
//public class Main {
//    public static void main(String[] args) throws IOException {
//        
//    }
//}

import java.io.*;
import java.util.*;

public class Main {
	static int n,m, state = 0;
	static int [][] map,copyMap;
	static boolean [][] visited;
	static int [] di = {1,-1,0,0};
	static int [] dj = {0,0,-1,1};
	static class Pos{
		int row, col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	map = new int[n][m];
    	copyMap = new int[n][m];
    	int time = 0;
    	int cnt = 0;
    	
    	for(int i = 0; i < n; i++) {
    		StringTokenizer temp = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			map[i][j] = Integer.parseInt(temp.nextToken());
    		}
    	}
    	
    	while(true) {
    		visited = new boolean[n][m];
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < m; j++) {
        			//1. 몇개 덩어리 인지 체크
        			if(map[i][j] != 0 && !visited[i][j]) {
        				cnt += 1;
        				bfs(i,j);
        			}
        		}
        	}
        	
        	if(cnt >= 2) {
        		System.out.println(time);
        		return;
        	}
        	//만약에 2개로 안 나눳으면 녹여
        	melt();
        	time += 1;
        	cnt = 0;
        	if(state == 0) {
        		System.out.println(0);
        		return;
        	}
        	state = 0;
    	}
    }
    
    
    static void bfs(int nowi, int nowj) {
    	visited[nowi][nowj] = true;
    	Queue<Pos> q = new LinkedList<>();
    	q.offer(new Pos(nowi, nowj));
    	
    	while(!q.isEmpty()) {
    		Pos temp = q.poll();
    		
    		for(int d = 0; d < 4; d++) {
    			int newi = di[d] + temp.row;
    			int newj = dj[d] + temp.col;
    			
    			if(newi >= 0 && newi < n && newj >= 0 && newj < m && !visited[newi][newj] && map[newi][newj] > 0) {
    				visited[newi][newj] = true;
    				q.offer(new Pos(newi, newj));
    			}
    		}
    	}
    }
    
    static void melt() {
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			copyMap[i][j] = map[i][j];
    		}
    	}
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(map[i][j] > 0) {
    				for(int d = 0; d < 4; d++) {
    					int newi = di[d] + i;
    					int newj = dj[d] + j;
    					
    					if(newi >= 0 && newi < n && newj >= 0 && newj < m && map[newi][newj] == 0 && copyMap[i][j] != 0) {
    						copyMap[i][j] -= 1;
    					}
    				}
    			}
    		}
    	}
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(copyMap[i][j] > 0) {
    				state = 1;
    			}
    			map[i][j] = copyMap[i][j];
    		}
    	}
    }
}