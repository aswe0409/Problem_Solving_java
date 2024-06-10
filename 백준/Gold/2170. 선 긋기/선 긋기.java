import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Pos implements Comparable<Pos>{
		int start , end;
		Pos(int start, int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Pos o) {//시작 위치가 같은 때 끝위치
			if(this.start == o.start) {
				return o.end - this.end;
			}
			return this.start - o.start;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		int ans = 0;
		if(!pq.isEmpty()) {
			Pos temp = pq.poll();
			int start = temp.start;
			int end = temp.end;
			while(!pq.isEmpty()) {
				Pos cur = pq.poll();
				if(cur.start <= end) {
					end = Math.max(end, cur.end);
				}
				else {
					ans += end - start;
					start = cur.start;
					end = cur.end;
				}
			}
			ans += end - start;
		}
		System.out.println(ans);
	}
}