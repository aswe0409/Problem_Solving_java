package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ex11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				// 절대값 기준으로
				if (Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				} else if (Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				} else {
					return -1;
				}
			}
		});

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x == 0) {
				// 비어 있으면 0
				if (pq.isEmpty()) {
					sb.append("0").append("\n");
				}
				// 절댓값 가장 작은 값 출력
				else {
					sb.append(pq.poll()).append("\n");
				}
			}

			else {
				pq.offer(x);
			}
		}
		System.out.println(sb);
	}
}
