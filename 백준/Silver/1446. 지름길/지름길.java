import java.io.*;
import java.util.*;

public class Main {
    static class SCut implements Comparable<SCut> {
        int start, end, length;
        SCut(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        SCut(int start, int length) {
            this.start = start;
            this.length = length;
        }

        @Override
        public int compareTo(SCut o) {
            return this.length - o.length;
        }
    }

    static List<SCut> arr = new ArrayList<>();
    static int n, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            if (e <= d) { // 목적지 넘어가는 건 무시
                arr.add(new SCut(s, e, l));
            }
        }

        System.out.println(bfs(0));
    }

    static public int bfs(int now) {
        PriorityQueue<SCut> pq = new PriorityQueue<>();
        pq.offer(new SCut(now, 0));

        int[] dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!pq.isEmpty()) {
            SCut temp = pq.poll();

            if (temp.start > d) continue;
            if (dist[temp.start] < temp.length) continue;

            if (temp.start == d) {
                return temp.length;
            }

            // 지름길
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).start == temp.start) {
                    if (dist[arr.get(i).end] > temp.length + arr.get(i).length) {
                        dist[arr.get(i).end] = temp.length + arr.get(i).length;
                        pq.offer(new SCut(arr.get(i).end, dist[arr.get(i).end]));
                    }
                }
            }

            // 일반도로
            if (temp.start + 1 <= d && dist[temp.start + 1] > temp.length + 1) {
                dist[temp.start + 1] = temp.length + 1;
                pq.offer(new SCut(temp.start + 1, dist[temp.start + 1]));
            }
        }

        return dist[d];
    }
}
