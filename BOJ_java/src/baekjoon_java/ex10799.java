package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ex10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");

        int sum = 0;
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < str.length; i++) {
            if(str[i].equals("(")) {
                stack.push(str[i]);
            }
            // 레이저
            else if(str[i].equals(")") && !stack.isEmpty() && str[i-1].equals("(")) {
                stack.pop();
                sum += stack.size();
            }
            // 막대기의 끝
            else if(str[i].equals(")") && !stack.isEmpty()) {
                stack.pop();
                sum += 1;
            }
        }
        System.out.println(sum);
    }
}
