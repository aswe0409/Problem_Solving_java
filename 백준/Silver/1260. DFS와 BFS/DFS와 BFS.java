import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,start;
	static ArrayList<Integer>[] arr;
	static boolean [] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		
		for(int i = 1; i <=n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
	       for(int i=1;i<=n;i++) {
	            Collections.sort(arr[i]);
	        }
	       visit = new boolean[n+1];
	    
	       dfs(start);
	       System.out.println();
	        visit = new boolean[n + 1];
	        bfs(start);

	}
	
	static void dfs(int start) {
		visit[start] = true;
		System.out.print(start+" ");
		for(int i =0; i <  arr[start].size(); i++) {
			int next = arr[start].get(i);
			if(!visit[next]) {
				dfs(next);
			}
		}
	}
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 0; i < arr[node].size(); i++) {
                int next = arr[node].get(i);
                if (!visit[next]) {
                    visit[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}