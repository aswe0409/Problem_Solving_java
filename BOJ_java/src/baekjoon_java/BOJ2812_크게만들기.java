package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2812_크게만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); 
        int remove = k;
        
        Deque<Character> dq = new ArrayDeque<>();
        String line = br.readLine(); // 숫자 문자열
        
        for (int i = 0; i < n; i++) {
            char temp = line.charAt(i);
            // 덱의 마지막 숫자가 현재 숫자보다 작으면 제거
            while (!dq.isEmpty() && remove > 0 && dq.peekLast() < temp) {
                dq.removeLast();
                remove--;
            }
            dq.addLast(temp);
        }

        // 제거 할 숫자가 남앗을 경우
        while (remove-- > 0) {
            dq.removeLast();
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }

        System.out.println(sb.toString());
    }
}
