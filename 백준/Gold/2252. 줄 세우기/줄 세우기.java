import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] degree = new int[n+1]; //진입차수
        List<Integer>[] arr = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++) {
        	arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
        	StringTokenizer temp = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(temp.nextToken());
            int b = Integer.parseInt(temp.nextToken());
            
            degree[b] += 1;
            arr[a].add(b);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i <= n; i++) {
        	if(degree[i] == 0) {
        		q.offer(i);
        	}
        }
        
        while(!q.isEmpty()) {
        	int now = q.poll();
        	System.out.print(now+ " ");
        	
        	for(int next: arr[now]) {
        		degree[next] -= 1;
        		if(degree[next] == 0) {
        			q.offer(next);
        		}
        	}
        }

    }
}