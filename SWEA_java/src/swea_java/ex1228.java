package swea_java;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ex1228 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			Queue<Integer> q = new ArrayDeque<Integer>();
			for(int i = 0; i < N; i++) {
				q.offer(sc.nextInt());
			}
			
			int cnt = sc.nextInt();
			
			for(int i = 0; i < cnt; i++) {
				String str = sc.next();
				int idx = sc.nextInt();
				int order = sc.nextInt();
				Queue<Integer> temp = new ArrayDeque<Integer>();
				
				for(int j = 0; j < idx; j++) {
					temp.offer(q.poll());
				}
				
				for(int j = 0; j < order; j++) {
					temp.offer(sc.nextInt());
				}
				
				while(!q.isEmpty()) {
					temp.offer(q.poll());
				}
				
				q.addAll(temp);
			}
            System.out.print("#" + tc);
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + q.poll());
            }
            System.out.println();
			
		}
	}
}
