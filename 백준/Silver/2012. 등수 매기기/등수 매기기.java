import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rank);
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt += Math.abs(i - rank[i] + 1);
        }
        System.out.println(cnt);
    }
}