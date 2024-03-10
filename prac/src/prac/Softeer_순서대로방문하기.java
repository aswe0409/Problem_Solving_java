package prac;

import java.util.Scanner;

public class Softeer_순서대로방문하기 {
    static class Pos {
        int row, col;

        Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};
    static int n, m, ret;
    static int[][] map;
    static boolean[][] visit;
    static Pos[] points;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        points = new Pos[m];
        visit = new boolean[n][n];
        ret = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            points[i] = new Pos(row, col);
        }

        visit[points[0].row][points[0].col] = true;
        dfs(0, points[0]);
        System.out.println(ret);
    }

    private static void dfs(int pointIdx, Pos now) {
        if (pointIdx == m - 1) {
            ret++;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int newi = now.row + di[k];
            int newj = now.col + dj[k];

            if (newi >= 0 && newi < n && newj >= 0 && newj < n && !visit[newi][newj] && map[newi][newj] == 0) {
                if (pointIdx + 1 < m && newi == points[pointIdx + 1].row && newj == points[pointIdx + 1].col) {
                    visit[newi][newj] = true;
                    dfs(pointIdx + 1, new Pos(newi, newj));
                    visit[newi][newj] = false;
                }
            }
        }
    }
}
