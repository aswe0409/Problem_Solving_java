package baekjoon_java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ex2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 숫자 갯수
		Deque<Integer> card = new ArrayDeque<Integer>();
				
		for(int i = 0; i < N; i++) {
			card.add(i+1);
		}
		
		while(card.size() != 1) {
			// 하나 빼기
			card.removeFirst();
			int temp = card.removeFirst();
			card.add(temp);
			// 하나 뒤로 보내기
		}
		
		System.out.println(card.getFirst());
	}
}
