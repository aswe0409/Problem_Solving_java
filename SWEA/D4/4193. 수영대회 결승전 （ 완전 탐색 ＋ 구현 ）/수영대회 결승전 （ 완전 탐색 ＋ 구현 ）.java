import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static class Pos {
        int row, col, cnt;

        Pos(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    static int[] di = { 1, -1, 0, 0 };
    static int[] dj = { 0, 0, -1, 1 };
    static int[][] arr;
    static int n;
    static Queue<Pos> q;
    static boolean[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            n = sc.nextInt();
            arr = new int[n][n];
            q = new LinkedList<>();
            visit = new boolean[n][n];

            // map 입력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            // 출발지 도착지 입력
            int starti = sc.nextInt();
            int startj = sc.nextInt();
            arr[starti][startj] = 3; // 시작지는 3으로 표시
            int endi = sc.nextInt();
            int endj = sc.nextInt();
            arr[endi][endj] = 4; // 도착지는 4로 표시
            int ret = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 3) {
                        ret = bfs(i, j);
                    }
                }
            }
            System.out.println("#" + test + " " + ret);
        }
    }

    static int bfs(int nowi, int nowj) {
        q.offer(new Pos(nowi, nowj, 0));
        visit[nowi][nowj] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pos temp = q.poll();

                for (int d = 0; d < 4; d++) {
                    int newi = temp.row + di[d];
                    int newj = temp.col + dj[d];

                    if (newi >= 0 && newi < n && newj >= 0 && newj < n  &&!visit[newi][newj] && arr[newi][newj] != 1) {
                        if (arr[newi][newj] == 2) {
                            if (temp.cnt % 3 == 2) {
                                q.offer(new Pos(newi, newj, temp.cnt + 1));
                                visit[newi][newj] = true;
                            }
                            else {
                            	q.offer(new Pos(temp.row, temp.col, temp.cnt+1));
                            }
                        }
                        else if(arr[newi][newj] == 0){
                            q.offer(new Pos(newi, newj, temp.cnt + 1));
                            visit[newi][newj] = true;
                        }
                    }
                    if(newi >=0 && newi < n && newj >= 0 && newj <n &&!visit[newi][newj] && arr[newi][newj] == 4) {
                        return temp.cnt+1;
                    }
                }
            }
        }
        return -1;
    }
}