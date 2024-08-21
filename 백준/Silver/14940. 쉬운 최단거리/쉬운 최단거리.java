import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int row, col, cnt;

        public Pos(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static int[][] map;
    static int[][] ans;
    static boolean[][] visited;
    static Queue<Pos> q;
    static int[] di = {0, 0, 1, -1};
    static int[] dj = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ans = new int[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    q.offer(new Pos(i, j, 0));
                    visited[i][j] = true;
                } else if (map[i][j] == 0) {
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        bfs();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Pos temp = q.poll();
            for (int d = 0; d < 4; d++) {
                int newi = temp.row + di[d];
                int newj = temp.col + dj[d];
                if (newi >= 0 && newi < N && newj >= 0 && newj < M && !visited[newi][newj] && map[newi][newj] == 1) {
                    visited[newi][newj] = true;
                    ans[newi][newj] = temp.cnt + 1;
                    q.offer(new Pos(newi, newj, temp.cnt + 1));
                }
            }
        }
    }
}