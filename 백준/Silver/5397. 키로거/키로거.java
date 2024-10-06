import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();

            for (char c : s.toCharArray()) {
                switch (c) {
                    case '<':
                        if (!left.isEmpty()) {
                            right.addLast(left.pollLast());
                        }
                        break;
                    case '>':
                        if (!right.isEmpty()) {
                            left.addLast(right.pollLast());
                        }
                        break;
                    case '-':
                        if (!left.isEmpty()) {
                            left.pollLast();
                        }
                        break;
                    default:
                        left.addLast(c);
                        break;
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!left.isEmpty()) {
                right.addLast(left.pollLast());
            }
            while (!right.isEmpty()) {
                sb.append(right.pollLast());
            }
            System.out.println(sb.toString());
        }
    }
}