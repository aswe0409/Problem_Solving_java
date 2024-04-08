import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static int min = Integer.MAX_VALUE;
	static PriorityQueue<Integer> pq;
	static class Pos{
		int idx, time;
		Pos(int idx, int time){
			this.idx = idx;
			this.time = time;
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
		pq = new PriorityQueue<Integer>();
		if(n == k) {
			System.out.println(0);
			return;
		}
		else {
			bfs();
			System.out.println(min);
			return;
		}
		
		//System.out.println(pq.poll());
	}
	
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		boolean visit[] = new boolean[100001];
		q.offer(new Pos(n,0));
		visit[n] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			
			if(temp.idx == k) {
				min = Math.min(min, temp.time);
			}
			
			for(int i = 0; i < 3; i++) {
				int next = temp.idx;
				if(i == 0) { //순간이동
					next = temp.idx * 2;
					if(next >= 0 && next < 100001 && !visit[next]) {
						q.offer(new Pos(next, temp.time));
						visit[next] = true;
					}
				}
				else if(i == 1) { //앞으로 1칸
					next = temp.idx - 1;
					if(next >= 0 && next < 100001 && !visit[next]) {
						q.offer(new Pos(next, temp.time+1));
						visit[next] = true;
					}
				}
				else {
					next = temp.idx + 1;
					if(next >= 0 && next < 100001 && !visit[next]) {
						q.offer(new Pos(next, temp.time+1));
						visit[next] = true;
					}
				}
				//System.out.println(q.toString());
			}
		}
		return;
	}
}