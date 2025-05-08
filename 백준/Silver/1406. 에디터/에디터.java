//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        
//    }
//}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            left.offer(str.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("L") && !left.isEmpty()) {
                right.offerFirst(left.pollLast());
            } else if (cmd.equals("D") && !right.isEmpty()) {
                left.offerLast(right.pollFirst());
            } else if (cmd.equals("B") && !left.isEmpty()) {
                left.pollLast();
            } else if (cmd.equals("P")) {
                char ch = st.nextToken().charAt(0);
                left.offerLast(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!left.isEmpty()) {
            sb.append(left.pollFirst());
        }
        while (!right.isEmpty()) {
            sb.append(right.pollFirst());
        }

        System.out.println(sb.toString());
    }
}