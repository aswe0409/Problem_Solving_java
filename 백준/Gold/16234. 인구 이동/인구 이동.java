//public class Main {
//    public static void main(String[] args) throws IOException {
//        
//    }
//}

import java.util.*;
import java.io.*;

public class Main {
	static int n,l,r,state;
	static int [][] map;
	static List<Pair> li;
	static boolean [][] visited;
	static int [] di = {0,0,-1,1};
	static int [] dj = {1,-1,0,0};
	static class Pos{
		int row, col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	static class Pair{
		int row, col, people;
		Pair(int row, int col, int people){
			this.row = row;
			this.col = col;
			this.people = people;
		}
	}
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	l = Integer.parseInt(st.nextToken());
    	r = Integer.parseInt(st.nextToken());
    	
    	map = new int[n][n];
    	
    	for(int i = 0; i < n; i++) {
    		StringTokenizer temp = new StringTokenizer(br.readLine());
    		for(int j = 0; j < n; j++) {
    			map[i][j] = Integer.parseInt(temp.nextToken());
    		}
    	}
    	int time = 0;
    	while(true) {
        	state = 0;
    		visited = new boolean[n][n];
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			if(!visited[i][j]) {
        				bfs(i,j);
        				if(li.size() > 1) {
                            divide();
                            state = 1;
                        }
        			}
        		}
        	}
        	
        	if(state == 0) {
        		System.out.println(time);
        		return;
        	}
        	time += 1;
    	} 
    }
    static void bfs(int nowi, int nowj) {
    	li = new ArrayList<>();
    	visited[nowi][nowj] = true;
    	Queue<Pos> q = new LinkedList<>();
    	li.add(new Pair(nowi, nowj, map[nowi][nowj]));
    	q.offer(new Pos(nowi, nowj));
    	
    	while(!q.isEmpty()) {
    		Pos temp = q.poll();
    		
    		for(int d = 0; d < 4; d++) {
    			int newi = di[d] + temp.row;
    			int newj = dj[d] + temp.col;
    			
    			if(newi >= 0 && newi < n && newj >= 0 && newj < n && !visited[newi][newj] &&
    					Math.abs(map[temp.row][temp.col] - map[newi][newj]) >= l && Math.abs(map[temp.row][temp.col] - map[newi][newj]) <= r) {
    				visited[newi][newj] = true;
    				q.offer(new Pos(newi, newj));
    				li.add(new Pair(newi, newj, map[newi][newj]));
    			}
    		}
    	}
    }
    
    static void divide() {
    	int size = li.size();
    	
    	int cnt = 0;
    	for(int i = 0; i < size; i++) {
    		cnt += li.get(i).people;
    	}
    	int people = cnt / size;
    	
    	for(int i = 0; i < size; i++) {
    		map[li.get(i).row][li.get(i).col] = people;
    	}
    }
    
    static void printMap() {
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			System.out.print(map[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
}