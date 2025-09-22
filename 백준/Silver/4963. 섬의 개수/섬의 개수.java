import java.io.*;
import java.util.*;

public class Main {
	static int w, h;
	static int [][] map;
	static int [] di = {1,-1,0,0,-1,1,1,-1};
	static int [] dj = {0,0,1,-1,-1,-1,1,1};
	static boolean [][] visited;
	
	static class Pos{
		int row, col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
       while(true) {
    	   StringTokenizer st = new StringTokenizer(br.readLine());
    	   w = Integer.parseInt(st.nextToken());
    	   h = Integer.parseInt(st.nextToken());
    	   
    	   if(w == 0 && h == 0) {
    		   return;
    	   }
    	   
    	   map = new int[h][w];
    	   visited = new boolean[h][w];
    	   
    	   for(int i = 0; i < h; i++) {
    		   StringTokenizer line = new StringTokenizer(br.readLine());
    		   for(int j = 0; j < w; j++) {
    			  map[i][j] = Integer.parseInt(line.nextToken()); 
    		   }
    	   }
    	   int cnt = 0;
    	   
    	   for(int i = 0; i < h; i++) {
    		   for(int j = 0; j < w; j++) {
    			   if(map[i][j] == 1 && !visited[i][j]) {
    				   bfs(i,j);
    				   cnt += 1;
    			   }
    		   }
    	   }
    	   System.out.println(cnt);
       }
    }
    static void bfs(int nowi, int nowj) {
    	Queue<Pos> q = new LinkedList<Pos>();
    	q.offer(new Pos(nowi, nowj));
    	visited[nowi][nowj] = true;
    	
    	while(!q.isEmpty()) {
    		Pos temp = q.poll();
    		for(int d = 0; d < 8; d++) {
    			int newi = di[d] + temp.row;
    			int newj = dj[d] + temp.col;
    			
    			if(newi >= 0 && newi < h && newj >= 0 && newj < w && !visited[newi][newj] && map[newi][newj] == 1) {
    				q.offer(new Pos(newi, newj));
    				visited[newi][newj] = true;
    			}
    		}
    	}
    }
}