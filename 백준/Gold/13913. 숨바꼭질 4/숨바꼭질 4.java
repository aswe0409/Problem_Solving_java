import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static StringBuilder sb = new StringBuilder();
	static class Pos{
		int idx, time;
		ArrayList<Integer> route;
		Pos(int idx, int time ,ArrayList<Integer> route){
			this.idx = idx;
			this.time = time;
			this.route = route;
		}
	
		@Override
		public String toString() {
			return "Pos [idx=" + idx + ", time=" + time + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		if(n == k) {
			System.out.println(0);
			System.out.println(n);
			return;
		}
		
		else if(n > k) {
			System.out.println(n-k);
			for(int i = n; i >= k; i--) {
				sb.append(i+" ");
			}
			System.out.println(sb.toString());
			return;
		}
		else {
			bfs();
			return;
		}
	}
	
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		boolean visit[] = new boolean[100001];
		
		q.offer(new Pos(n,0, new ArrayList<Integer>()));
		visit[n] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			for(int i = 0; i < 3; i++) {
				int next = 0;
				if(i == 0) { //순간이동
					next = temp.idx * 2;
					if(next >= 0 && next < 100001 && !visit[next]) {
						ArrayList<Integer> newPath = new ArrayList<>(temp.route);
						newPath.add(next);
						q.offer(new Pos(next, temp.time+1,newPath ));
						visit[next] = true;
					}
				}
				else if(i == 1) { //앞으로 1칸
					next = temp.idx - 1;
					if(next >= 0 && next < 100001 && !visit[next]) {
						ArrayList<Integer> newPath = new ArrayList<>(temp.route);
						newPath.add(next);
						q.offer(new Pos(next, temp.time+1,newPath));
						visit[next] = true;
					}
				}
				else {
					next = temp.idx + 1;
					if(next >= 0 && next < 100001 && !visit[next]) {
						ArrayList<Integer> newPath = new ArrayList<>(temp.route);
						newPath.add(next);
						q.offer(new Pos(next, temp.time+1,newPath));
						visit[next] = true;
					}
				}
				//System.out.println(q.toString());
				if(next == k) {
				    System.out.println(temp.time+1);
				    
				    sb.append(n).append(" ");
				    for(int d = 0; d < temp.route.size(); d++) {
				        sb.append(temp.route.get(d)).append(" ");
				    }
				    sb.append(k);
				    System.out.println(sb.toString());
				    return;
				}
			}
		}
	}
}