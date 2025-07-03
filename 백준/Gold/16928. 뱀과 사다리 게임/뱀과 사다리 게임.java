import java.io.*;
import java.util.*;

public class Main {
	static class Pos implements Comparable<Pos>{
		int idx, cnt;
		Pos(int idx, int cnt){
			this.idx = idx;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Pos o) {
			return this.cnt - o.cnt;	
		}
	}
	
	static boolean[] visited;
	static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        arr = new int[101];
        visited = new boolean[101];
        
        for(int i = 0; i < n+m; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        bfs(1);
    }
    
    static public void bfs(int start) {
    	PriorityQueue<Pos> pq = new PriorityQueue<>();
    	pq.offer(new Pos(start ,0));
    	visited[start] = true;
    	
    	while(!pq.isEmpty()) {
    		Pos temp = pq.poll();
    		
    		
    		for(int d = 1; d <= 6; d++) {
    			int newi = temp.idx + d;
    			if(newi >= 1 && newi <= 100&& arr[newi] != 0) {
    				newi = arr[newi];
    			}
    			
        		if(temp.idx == 100) {
        			System.out.println(temp.cnt);
        			return;
        		}
    			
    			if(newi >= 1 && newi <= 100 &&!visited[newi]) {
    				visited[newi] = true;
    				pq.offer(new Pos(newi, temp.cnt + 1));
    			}
    		}
    	}
    }
}