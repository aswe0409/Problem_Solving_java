import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n; // 수빈이 위치
    static int k; // 동생 위치

    static int arr[];
    static boolean visited[];
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        visited = new boolean[100001];
        q = new LinkedList<>();

        if (n == k) {
            System.out.println(0);
        } else {
            bfs(n);
        }
    }

    private static void bfs(int now) {
        q.offer(now);
        arr[now] = 0;
        visited[now] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 0) { // 한 칸 뒤
                    next = temp - 1;
                } else if (i == 1) { // 한 칸 앞
                    next = temp + 1;
                } else { // 순간 이동
                    next = temp * 2;
                }

                if (next == k) {
                    System.out.println(arr[temp] + 1);
                    return;
                } else {
                    if (next >= 0 && next < 100001 && !visited[next]) {
                        arr[next] = arr[temp] + 1;
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
        }
    }
}