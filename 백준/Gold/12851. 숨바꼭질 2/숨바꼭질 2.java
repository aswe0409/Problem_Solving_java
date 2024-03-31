import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n; // 수빈이 위치
    static int k; // 동생 위치
    static int[] arr = new int[100001];
    static int cnt = 0, ret = Integer.MAX_VALUE;

    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arrays.fill(arr, Integer.MAX_VALUE); // 배열을 최대값으로 초기화
        q = new LinkedList<>();

        if (n == k) {
            System.out.println(0);
            System.out.println(1);
        } else {
            bfs(n);
            System.out.println(ret);
            System.out.println(cnt);
        }
    }

    private static void bfs(int now) {
        q.offer(now);
        arr[now] = 0;

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

                // 다음 위치로 이동하는데 걸리는 시간
                int nextTime = arr[temp] + 1;

                // 동생을 찾았고, 찾는 데 걸린 시간이 기존 최단 시간과 같다면 방법의 수만 증가
                if (next == k && nextTime == ret) {
                    cnt++;
                }
                // 아직 방문하지 않았거나, 다음 위치로 이동하는데 걸린 시간이 현재 기록된 시간보다 작거나 같다면 큐에 추가
                else if (next >= 0 && next < 100001 &&arr[next] >= nextTime) {
                    // 최단 시간과 해당 시간으로 찾는 방법의 수 업데이트
                    if (next == k) {
                        ret = nextTime;
                        cnt = 1; // 최단 시간을 처음 찾았으므로 방법의 수를 1로 초기화
                    }
                    arr[next] = nextTime;
                    q.add(next);
                }
            }
        }
    }
}