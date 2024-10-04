import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int front = 0;
        int rear = n - 1;
        while (front < rear) {
            if (arr[front] + arr[rear] == target) {
                ans += 1;
                front += 1;
                rear -= 1;
            } else if (arr[front] + arr[rear] < target) {
                front += 1;
            } else if (arr[front] + arr[rear] > target) {
                rear -= 1;
            }
        }
        System.out.println(ans);
    }
}