
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> minQ = new PriorityQueue<>((o1, o2) -> o1 - o2);
		PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(minQ.size() == maxQ.size()) {
				maxQ.offer(num);
			}
			else {
				minQ.offer(num);
			}
			
			//스왑
			if(!minQ.isEmpty() && !maxQ.isEmpty()) {
				if(minQ.peek() < maxQ.peek()) {
					int temp = minQ.poll();
					minQ.offer(maxQ.poll());
					maxQ.offer(temp);
				}
			}
			sb.append(maxQ.peek() + "\n");
		}
		System.out.println(sb);
	}
}
