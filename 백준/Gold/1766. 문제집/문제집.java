import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] degree = new int[n+1];
        List<Integer>[] arr = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++) {
        	arr[i] = new ArrayList<>();
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	degree[end] += 1;
        	arr[start].add(end);
        }
        
        for(int i = 1; i<= n; i++) {
        	if(degree[i] == 0) {
        		pq.offer(i);
        	}
        }
        
        while(!pq.isEmpty()) {
        	int now = pq.poll();
        	System.out.print(now+" ");
        	
        	for(int next: arr[now]) {
        		degree[next] -= 1;
        		
        		if(degree[next] == 0) {
        			pq.offer(next);
        		}
        	}
        }
    }
}