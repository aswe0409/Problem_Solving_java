import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] color;
    static boolean isTrue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            color = new int[V + 1];
            isTrue = true;

            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    bfs(i);
                }
            }

            System.out.println(isTrue ? "YES" : "NO");
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 1; // 첫 노드를 빨강

        while (!q.isEmpty() && isTrue) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                if (color[next] == 0) {
                    color[next] = 3 - color[now];
                    q.offer(next);
                } else if (color[next] == color[now]) {
                	isTrue = false;
                    return;
                }
            }
        }
    }
}
