import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int ret = 0;
		int val = 1;
		Stack<Character> stack = new Stack();  
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.push(str.charAt(i));
				val *= 2;
			}
			else if(str.charAt(i) == '[') {
				val *= 3;
				stack.push(str.charAt(i));
			}
			else if(str.charAt(i) == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					ret = 0;
					break;
				}
				else if(str.charAt(i-1) == '('){
					ret += val;
				}
				stack.pop();
				val /= 2;
			}
			else if(str.charAt(i) == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					ret = 0;
					break;
				}
				else if(str.charAt(i-1) == '['){
					ret += val;
				}
				stack.pop();
				val /= 3;
			}
		}
		
		if(!stack.isEmpty()) { // 스택에 남아있으면 괄호 완성 X
			System.out.println(0);
		}
		else {
			System.out.println(ret);
		}
	}
}