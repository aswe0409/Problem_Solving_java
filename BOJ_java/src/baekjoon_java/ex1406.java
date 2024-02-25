package baekjoon_java;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ex1406 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Character> left = new LinkedList<>(); // 왼쪽의 문자들
		Deque<Character> right = new LinkedList<>(); // 오른쪽의 문자들

		String str = sc.nextLine();
		int N = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < str.length(); i++) {
			left.addLast(str.charAt(i));
		}

		for (int i = 0; i < N; i++) {
			char order = sc.next().charAt(0);
			switch (order) {
			case 'P': 
				char input = sc.next().charAt(0);
				left.add(input);
				break;
			case 'L': 
				if (!left.isEmpty()) {
					right.addFirst(left.removeLast());
				}
				break;
			case 'D':
				if (!right.isEmpty()) {
					left.addLast(right.removeFirst());
				}
				break;
			case 'B': 
				if (!left.isEmpty()) {
					left.removeLast();
				}	
				break;
			

			}
		}
		StringBuilder sb = new StringBuilder();
		
//		for(char ch : left) {
//			System.out.println(ch);
//		}
		
//		for(char ch : right) {
//			System.out.println(ch);
//		}
        while (!right.isEmpty()) {
        	left.add(right.remove());
        }
        while (!left.isEmpty()) {
            sb.append(left.removeFirst());
        }
		System.out.println(sb.toString());
	}
}
