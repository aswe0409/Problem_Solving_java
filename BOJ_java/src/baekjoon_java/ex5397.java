package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ex5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            String input = br.readLine();
            Stack<Character> left = new Stack<>(); // 왼쪽의 문자들
            Stack<Character> right = new Stack<>(); // 오른쪽의 문자들

            for (char ch : input.toCharArray()) {
                switch (ch) {
                    case '<': 
                        if (!left.isEmpty()) {
                        	right.push(left.pop());
                        }
                        break;
                    case '>': 
                        if (!right.isEmpty()) {
                        	left.push(right.pop());
                        }
                        break;
                    case '-': 
                        if (!left.isEmpty()) {
                        	left.pop();
                        }
                        break;
                    default: 
                    	left.push(ch);
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!left.isEmpty()) {
            	right.push(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }

            System.out.println(sb.toString());
        }
    }
}