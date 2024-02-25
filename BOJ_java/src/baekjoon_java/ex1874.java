package baekjoon_java;

import java.util.Scanner;
import java.util.Stack;

public class ex1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		StringBuffer sf = new StringBuffer();
		Stack<Integer> stack = new Stack<Integer>();
		int num = 1;
		int state = 0;
		
		for(int i = 0; i <arr.length; i++) {
			int temp = arr[i];
			if(temp >= num) {	
				while(temp >= num) {
					stack.push(num++);
					sf.append("+\n");
					//System.out.println("+");
				}
				stack.pop();
				sf.append("-\n");
			}
			else {
				int n1 = stack.pop();
				if(n1 > temp) {
					System.out.println("NO");
					state = 1;
					break;
				}
				else {
					sf.append("-\n");
				}
			}
		}
		if(state != 1) {
			System.out.println(sf.toString());
		}
	}
}
