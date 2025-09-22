import java.io.*;
import java.util.*;

public class Main {
	static int m,n,h;
	static int [][][] map;
	static int [] di = {0,0,-1,1,0,0}; // 위 아래 왼 오 앞 뒤
	static int [] dj = {-1,1,0,0,0,0};
	static int [] dz = {0,0,0,0,1,-1};
	static Queue<Pos> q;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        map = new int[h][n][m];
        q = new LinkedList<>();
        
        for(int i = 0; i < h; i++) {
        	for(int j = 0; j < n; j++) {
        		StringTokenizer temp = new StringTokenizer(br.readLine());
        		for(int k = 0; k < m; k++) {
        			map[i][j][k] = Integer.parseInt(temp.nextToken());
        		}
        	}
        }
        
        for(int i = 0; i < h; i++) {
        	for(int j = 0; j < n; j++) {
        		for(int k = 0; k < m; k++) {
        			if(map[i][j][k] == 1) {
            			q.offer(new Pos(j,k,i,0));
        			}
        		}
        	}
        }
        int ret = bfs();
        System.out.println(ret);
    }
    
    static int bfs() {
    	while(!q.isEmpty()) {
    		Pos temp = q.poll();
    		
    		for(int d = 0; d < 6; d++) {
    			int newi = di[d] + temp.row;
    			int newj = dj[d] + temp.col;
    			int newz = dz[d] + temp.height;
    			
    			if(newi >= 0 && newi < n && newj >= 0 && newj < m && newz >= 0 && newz < h && map[newz][newi][newj] == 0) {
    				map[newz][newi][newj] = map[temp.height][temp.row][temp.col] + 1;
    				q.offer(new Pos(newi, newj, newz, temp.cnt + 1));
    			}
    		}
    	}
    	//맵 체크
    	int cnt = 0;
    	for(int i = 0; i < h; i++) {
        	for(int j = 0; j < n; j++) {
        		for(int k = 0; k < m; k++) {
        			if(map[i][j][k] == 0) {
        				return -1;
        			}
        			else {
        				cnt = Math.max(cnt , map[i][j][k]);
        			}
        		}
        	}
        }
    	return cnt -1;
    }
}