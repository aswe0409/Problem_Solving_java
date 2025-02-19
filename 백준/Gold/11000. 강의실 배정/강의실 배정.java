import java.io.*;
import java.util.*;

public class Main {
	static class Time implements Comparable<Time> {
		int start, end;
		Time(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Time o) {
			if(this.start != o.start) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		Time [] lecture = new Time[n];
		for(int i = 0; i < n; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			lecture[i] = new Time(n1,n2);
		}
		
		Arrays.sort(lecture);

		for(int i = 0; i < n; i++) {
			if (!pq.isEmpty() && pq.peek() <= lecture[i].start) {
			    pq.poll(); 
			}
			pq.offer(lecture[i].end);
		}
		System.out.println(pq.size());
	}
}