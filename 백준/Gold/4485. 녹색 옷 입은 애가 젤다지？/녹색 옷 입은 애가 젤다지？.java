import java.io.*;
import java.util.*;

public class Main {
	static class Pos implements Comparable<Pos>{
		int row, col, cnt;
		Pos(int row, int col, int cnt){
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Pos o) {
			return this.cnt - o.cnt;
		}
	}
	
	static int n;
	static int map[][];
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;
        while(true) {
            n = Integer.parseInt(br.readLine());
            if(n == 0) {
            	break;
            }
            
            map = new int[n][n];
            
            for(int i = 0; i < n; i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < n; j++) {
            		map[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            
            int cnt = bfs(0,0);
            System.out.println("Problem "+ idx+": "+ cnt);
            idx += 1;
        }
    }
    
    static int bfs(int nowi, int nowj) {
    	PriorityQueue<Pos> pq = new PriorityQueue<>();
        visited = new boolean[n][n];
        pq.offer(new Pos(nowi, nowj, map[nowi][nowj]));
        visited[nowi][nowj] = true;
        int ret = 0;
        
        while(!pq.isEmpty()) {
        	Pos temp = pq.poll();
        	
        	if(temp.row == n-1 && temp.col == n-1) {
        		ret = temp.cnt;
        	}
        	
        	for(int d = 0; d < 4; d++) {
        		int newi = temp.row + di[d];
        		int newj = temp.col + dj[d];
        		
        		if(newi >= 0 && newi < n && newj >=0 && newj < n && !visited[newi][newj]) {
        			pq.offer(new Pos(newi, newj, temp.cnt + map[newi][newj]));
        			visited[newi][newj] = true;
        		}
        	}
        }
    	return ret;
    }
}