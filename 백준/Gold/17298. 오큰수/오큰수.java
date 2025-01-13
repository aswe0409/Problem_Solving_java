import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int [] arr = new int[n];
		int [] ret = new int[n];
		Stack<Integer> stack = new Stack();
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n-1; i++) {
			if(arr[i] < arr[i+1]) { // 나보다 왼쪽이 크면 넣어
				ret[i] = arr[i+1];
				while(!stack.isEmpty()) {
					int idx = stack.pop();
					if(arr[idx] < arr[i+1]) {
						ret[idx] = arr[i+1];
					}
					else {
						stack.push(idx);
						break;
					}
				}
			}
			
			else { // 나보다 왼쪽이 작으면 뒤로 갈수록 클 수도 있고 아닐 수도 있어
				stack.push(i); // 값 못들어간 위치를 stack에 넣어줘
			}
		}
		
		for(int i = 0; i< n; i++) {
			if(ret[i] == 0) {
				sb.append(-1).append(' ');
			}
			else {
				sb.append(ret[i]).append(' ');
			}
		}
		System.out.println(sb);
	}
}