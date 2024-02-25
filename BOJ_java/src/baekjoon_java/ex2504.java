package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ex2504 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < str.length; i++) {
        	if(str[i].equals("(") || str[i].equals("[")){
        		stack.push(str[i]);
        	}
        	
        }
	}
}
