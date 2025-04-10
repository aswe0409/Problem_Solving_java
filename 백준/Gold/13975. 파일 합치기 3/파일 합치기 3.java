import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < test; t++) {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			
			long sum = 0;
			while(pq.size() > 1) {
				long num1 = pq.poll();
				long num2 = pq.poll();

				long temp = num1 + num2;
				
				sum += temp;
				pq.add(temp);
			}
			System.out.println(sum);
		}
	}
}
