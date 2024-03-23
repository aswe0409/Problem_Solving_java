package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15591_MooTube {
	static class Pos{
		int idx, usado;
		Pos(int idx, int usado){
			this.idx = idx; // 연결 되어 있는애 1번 인덱스 부터 사용하자
			this.usado = usado; // 유사도
		}
	}
	
	static LinkedList<Pos>[] arr;
	static int n, q,k,v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q  = Integer.parseInt(st.nextToken());
		
		arr = new LinkedList[n+1]; 
		for(int i = 0; i <=n; i++) {
			arr[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < n-1; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int r = Integer.parseInt(str.nextToken());
			
			arr[a].add(new Pos(b,r));
			arr[b].add(new Pos(a,r));

		}
		
		for(int i = 0; i < q; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(str.nextToken());
			v = Integer.parseInt(str.nextToken());
			System.out.println(bfs(k,v));
		}
	}
	
	static int bfs(int k, int v) {
		int cnt = 0;
		boolean [] visit = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visit[v] = true;
		
	    while(!q.isEmpty()) {
	        int temp = q.poll();
	        for(Pos next : arr[temp]) {
	            if(!visit[next.idx] && next.usado >= k) {
	                cnt += 1;
	                q.offer(next.idx);
	                visit[next.idx] = true;
	            }
	        }
	    }
	    return cnt;
	}
}
