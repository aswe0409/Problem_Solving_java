package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17836_공주님을구해라3차원배열 {
    static class Pos {
        int row, col, cnt, state;

        Pos(int row, int col, int cnt, int state) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.state = state;
        }
    }

    static int n, m, t;
    static int[][] arr;
    static boolean[][][] visit; 
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m][2]; // z 가 0 이면 칼 안 얻음 1이면 칼 얻음

        for (int i = 0; i < n; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        bfs();
    }

    private static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(0, 0, 0, 0));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Pos temp = q.poll();

            if (temp.cnt > t) {
                continue;
            }

            if (temp.row == n - 1 && temp.col == m - 1) {
                System.out.println(temp.cnt);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int newi = temp.row + di[k];
                int newj = temp.col + dj[k];

                if (newi >= 0 && newi < n && newj >= 0 && newj < m) {
                    // 칼 없어
                    if (temp.state == 0 && !visit[newi][newj][0] && (arr[newi][newj] == 0 || arr[newi][newj] == 2)) {
                        visit[newi][newj][0] = true;
                        int nextState = arr[newi][newj] == 2 ? 1 : 0; // 칼을 찾으면 상태를 변경
                        q.offer(new Pos(newi, newj, temp.cnt + 1, nextState));
                    }

                    // 칼을 얻음
                    if (temp.state == 1 && !visit[newi][newj][1]) { // 모든칸 방문 가능
                        visit[newi][newj][1] = true;
                        q.offer(new Pos(newi, newj, temp.cnt + 1, 1));
                    }
                }
            }
        }
        System.out.println("Fail");
    }
}
