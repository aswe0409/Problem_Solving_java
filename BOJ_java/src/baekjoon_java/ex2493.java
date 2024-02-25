package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ex2493 {
	static class Tower{
		int idx, height;
		public Tower(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
	}
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Tower> stack = new Stack<Tower>();
		
		for(int i = 1; i <= N; i++) {
			int h = Integer.parseInt(st.nextToken());
			
			//스택 확인하고 있는애가 키가 작으면 pop
			while(!stack.isEmpty() && stack.peek().height < h) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				sb.append(0+" ");
			}
			else {
				sb.append(stack.peek().idx+" ");
			}
			stack.push(new Tower(i, h));
		}
		System.out.println(sb.toString());
	}
}
