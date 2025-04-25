import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 1;
		
		while(true) {
			int cnt = 0;
			String str = br.readLine();
			
			if(str.charAt(0) == '-') {
				return;
			}
			
			char []arr = new char[str.length()];
			for(int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
			}
			
			Stack<Character> stack = new Stack<>();
			
			for(int i = 0; i < str.length(); i++) {
				if(stack.isEmpty()) {
					if(arr[i] == '}') {
						cnt += 1;
						
					}
					stack.push('{');
				}
				else {
					if(arr[i] == '}' && stack.peek() == '{') {
						stack.pop();
					}
					else {
						stack.push(arr[i]);
					}
				}
			}
			System.out.println(idx+". "+ (cnt + (int)stack.size()/2));
			idx +=1;
		}
	}
}
