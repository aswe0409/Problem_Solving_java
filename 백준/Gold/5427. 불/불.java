import java.io.*;
import java.util.*;

public class Main {
	static char [][] map;
	static boolean [][] visited;
	static int w, h, state;
	static int [] di = {0,0,1,-1}; // 동서남북
	static int [] dj = {1,-1,0,0};
	static Queue<Pos> q;
	static Queue<Pos> peopleQ;
	static class Pos{
		int row, col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int test = Integer.parseInt(br.readLine());
    	
    	for(int t = 0; t < test; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		w = Integer.parseInt(st.nextToken());
    		h = Integer.parseInt(st.nextToken());
    		map = new char[h][w];
    		visited = new boolean[h][w];
    		q = new LinkedList<>();
    		peopleQ = new LinkedList();
    		state = 0; // 0이면 탈출 전, 1이면 탈출
    		
    		int starti = 0;
    		int startj = 0;
    		
    		for(int i = 0; i < h; i++) {
    			String line = br.readLine();
    			for(int j = 0; j < w; j++) {
    				map[i][j] = line.charAt(j);
    				if(map[i][j] == '@') {
    					starti = i;
    					startj = j;
    					peopleQ.offer(new Pos(i,j));
    					visited[i][j] = true;
    				}
    				else if(map[i][j] == '*') {
    					q.offer(new Pos(i,j));
    				}
    			}
    		}
    		
    		int cnt = 0;
    		
    		//탈출 못했으면 계속 돌리기, 불 먼저 출발하고 상근이 탈출 시도
    		while(!peopleQ.isEmpty() && state == 0) {
    			fire();
    			escape();
    			cnt += 1;
    		}
    		if(state == 1) {
    			System.out.println(cnt);
    		}
    		else {
    			System.out.println("IMPOSSIBLE");
    		}
    	} 
    }
    
    static void fire() {
    	int size = q.size();
    	for(int i = 0; i < size; i++) {
    		Pos temp = q.poll();
    		
    		for(int d = 0; d < 4; d++) {
    			int newi = di[d] + temp.row;
    			int newj = dj[d] + temp.col;
    			
    			if(newi >= 0 && newi < h && newj >= 0 && newj < w && map[newi][newj] == '.') {
    				map[newi][newj] = '*';
    				q.offer(new Pos(newi, newj));
    			}
    		}
    	}
    }

    static void escape() {
    	int size = peopleQ.size();
    	for(int i = 0; i < size; i++) {
    		Pos temp = peopleQ.poll();
    		
    		for(int d = 0; d < 4; d++) {
    			int newi = di[d] + temp.row;
    			int newj = dj[d] + temp.col;
    			
    			//탈출 체크
    			if(newi < 0 || newi >= h || newj < 0 || newj >= w) {
    				state = 1;
    				return;
    			}
    			if(newi >= 0 && newi < h && newj >= 0 && newj < w && map[newi][newj] == '.'&& !visited[newi][newj]) {
    				visited[newi][newj] = true;
    				peopleQ.offer(new Pos(newi, newj));
    			}
    		}
    	}
    }
}