package swea_java;

import java.util.Scanner;
import java.util.Stack;

public class ex1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int num = sc.nextInt();
			sc.nextLine(); // garbage
			String s = sc.nextLine();

			Stack<Character> stack = new Stack<>();
			boolean isBalanced = true;

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
					stack.push(ch);
				} else {
					if (stack.isEmpty()) {
						isBalanced = false;
						break;
					}
					char top = stack.peek();
					if ((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')
							|| (ch == '>' && top == '<')) {
						stack.pop(); // 올바른 매칭이므로 여는 괄호 제거
					} else {
						// 매칭되지 않음
						isBalanced = false;
						break;
					}
				}
			}

			if (!stack.isEmpty()) {
				isBalanced = false;
			}

			System.out.println("#" + tc + " " + (isBalanced ? 1 : 0));
		}
	}
}