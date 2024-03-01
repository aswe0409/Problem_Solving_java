package prac;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class test {
	static int n, k, arr[];
	static boolean visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();

		arr = new int[100001];
		visited = new boolean[100001];

		if (n == k) {
			System.out.println(0);
		}
		else {
			bfs(n, 0);
		}
	}

	public static void bfs(int now, int time) {
		Queue<point> queue = new ArrayDeque<>();
		queue.offer(new point(now, time));

		visited[now] = true;
		while (!queue.isEmpty()) {
			point current = queue.poll();

			int 더하기일 = current.start + 1;
			int 빼기일 = current.start - 1;
			int 곱하기이 = current.start * 2;

			if (더하기일 == k || 빼기일 == k || 곱하기이 == k) {
				System.out.println(current.second + 1);
//				System.out.println("gggggggg");
				break;
			}
			if (더하기일 >= 1 && 더하기일 <= k && !visited[더하기일]) {
				queue.offer(new point(더하기일, current.second + 1));
				visited[더하기일] = true;
			}
			if (빼기일 >= 1 && 빼기일 <= k && !visited[빼기일]) {
				queue.offer(new point(빼기일, current.second + 1));
				visited[빼기일] = true;
			}
			if (곱하기이 >= 1 && 곱하기이 <= k && !visited[곱하기이]) {
				queue.offer(new point(곱하기이, current.second + 1));
				visited[곱하기이] = true;
			}
		}

	}

	public static class point {
		int start;
		int second;

		public point(int s, int c) {
			this.start = s;
			this.second = c;
		}
	}
}
