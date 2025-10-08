import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] cha = new int[n+1];
        int[] ret = new int[n+1];
        List<Integer>[] arr = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++) {
        	arr[i] = new ArrayList<>();
        }
        
        for(int i = 1; i <= m; i++) {
        	StringTokenizer temp = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(temp.nextToken());
        	int end = Integer.parseInt(temp.nextToken());
        	
        	arr[start].add(end);
        	cha[end] += 1;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        //초기 설정
        for(int i = 1; i <= n; i++) {
        	if(cha[i] == 0) {
        		q.offer(i);
        		ret[i] = 1;
        	}
        }
        
        while(!q.isEmpty()) {
        	int now = q.poll();
        	
        	for(int next: arr[now]) {
        		cha[next] -= 1;
        		
        		ret[next] = Math.max(ret[next], ret[now] + 1);
        		
        		if(cha[next] == 0) {
        			q.offer(next);
        		}
        	}
        }
        for(int i = 1; i <= n; i++) {
        	System.out.print(ret[i] + " ");
        }
    }
}