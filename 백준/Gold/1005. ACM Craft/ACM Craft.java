import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 0; t < test; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 건물 개수
            int m = Integer.parseInt(st.nextToken()); // 건설 순서 규칙 수

            int[] time = new int[n + 1];     // 각 건물 건설 시간
            int[] degree = new int[n + 1];   // 진입 차수
            List<Integer>[] arr = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) {
                arr[i] = new ArrayList<>();
            }

            // 건물 짓는 데 걸리는 시간 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            // 건물 순서 관계 입력
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                arr[start].add(end);
                degree[end] += 1;
            }

            int target = Integer.parseInt(br.readLine()); // 목표 건물

            // 위상 정렬을 위한 큐
            Queue<Integer> q = new LinkedList<>();
            int[] result = new int[n + 1]; // 각 건물 완성까지 걸리는 누적 시간

            for (int i = 1; i <= n; i++) {
                result[i] = time[i]; 
                if (degree[i] == 0) {
                    q.offer(i);
                }
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int next : arr[now]) {
                    result[next] = Math.max(result[next], result[now] + time[next]);
                    
                    degree[next] -= 1;
                    if (degree[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            System.out.println(result[target]);
        }
    }
}