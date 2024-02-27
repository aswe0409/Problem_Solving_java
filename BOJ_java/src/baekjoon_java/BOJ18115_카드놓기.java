package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ18115_카드놓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new LinkedList<Integer>(); //결과 담을배열
		int [] order = new int[n]; //명령어 담을 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		int card = 1;
		for (int i = n; i >= 1; i--) {
			int num = order[i-1];
            if (num == 1) {
                dq.addFirst(card);
                card++;
            } else if (num == 2) {
                int temp = dq.removeFirst();
                dq.addFirst(card);
                dq.addFirst(temp);
                card++;
            } else {
                dq.addLast(card);
                card++;
            }
		}
		
	       StringBuilder sb = new StringBuilder();
	        while (!dq.isEmpty()) {
	            sb.append(dq.removeFirst()).append(" ");
	        }
	        System.out.println(sb.toString().trim());
		
	}
}
