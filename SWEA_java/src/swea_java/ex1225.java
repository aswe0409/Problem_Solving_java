package swea_java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ex1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int TC = 0; TC<10; TC++) {
			int tc = sc.nextInt();
			Deque<Integer> dq = new ArrayDeque<Integer>();
			for(int i = 0; i < 8; i++) {
				dq.add(sc.nextInt());
			}
			
			int cnt = 1;
			while(true){
				int temp = dq.removeFirst();
				temp -= cnt;
				
				if (temp <= 0) {
					dq.add(0);
					break;
				}
				
				else {
					dq.add(temp);
					
				}
				cnt = (cnt % 5) + 1;
			}
			System.out.print("#"+tc);
			for(int i = 0; i < 8; i++) {
				System.out.print(" "+dq.removeFirst() );
			}
			System.out.println();
		}
	}
}
