import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> ret = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            dq.addLast(i);
        }

        while(!dq.isEmpty()){
            for(int i = 0; i < k-1; i++){
                dq.addLast(dq.pollFirst());
            }
            ret.add(dq.pollFirst());
        }
        System.out.print("<" + ret.get(0));
        for(int i = 1; i < n; i++){
            System.out.print(", "+ret.get(i));
        }
        System.out.print('>');
    }
}