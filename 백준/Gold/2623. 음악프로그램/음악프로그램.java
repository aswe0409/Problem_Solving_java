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
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int num = Integer.parseInt(st.nextToken());
        	int before = Integer.parseInt(st.nextToken());
        	// 처음거만 먼저
        	for(int j = 0; j < num-1; j++) {
        		int temp = Integer.parseInt(st.nextToken());
        		arr[before].add(temp);
        		degree[temp] += 1;
        		before = temp;
        	}
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i <= n; i++) {
        	if(degree[i] == 0) {
        		q.offer(i);
        	}
        }
        
        if(q.isEmpty()) {
        	System.out.println(0);
        	return;
        }
        List<Integer> ret = new ArrayList<>();
        
        while(!q.isEmpty()) {
        	int now = q.poll();
        	ret.add(now);
        	
        	for(int next : arr[now]) {
        		degree[next] -= 1;
        		
        		if(degree[next] == 0) {
        			q.offer(next);
        		}
        	} 	
        }
        
        if(ret.size() != n) {
        	System.out.println(0);
        	return;
        }
        for(int i = 0; i < n; i++) {
        	System.out.println(ret.get(i));
        }
    }
}