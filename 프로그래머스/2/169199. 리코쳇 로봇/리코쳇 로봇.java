import java.util.*;

class Solution {
    static class Pos {
        int row, col, cnt;
        Pos(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dj = {0, 0, -1, 1};
    static Queue<Pos> q;

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        map = new char[n][m];
        visited = new boolean[n][m];
        q = new LinkedList<>();

        int starti = 0, startj = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    starti = i;
                    startj = j;
                }
            }
        }
        
        return bfs(starti, startj);
    }

    static int bfs(int nowi, int nowj) {
        q.offer(new Pos(nowi, nowj, 0));
        visited[nowi][nowj] = true;

        while (!q.isEmpty()) {
            Pos temp = q.poll();

            for (int d = 0; d < 4; d++) {
                int newi = temp.row;
                int newj = temp.col;

                // 벽이나 경계를 만날 때까지 이동
                while (true) {
                    int nexti = newi + di[d];
                    int nextj = newj + dj[d];

                    // 벽이나 경계에 닿으면 현재 위치에서 멈춤
                    if (nexti < 0 || nexti >= n || nextj < 0 || nextj >= m || map[nexti][nextj] == 'D') {
                        break;
                    }

                    newi = nexti;
                    newj = nextj;
                }


                if (map[newi][newj] == 'G') {
                    return temp.cnt + 1;
                }

                if (!visited[newi][newj]) {
                    q.offer(new Pos(newi, newj, temp.cnt + 1));
                    visited[newi][newj] = true;
                }
            }
        }
        return -1;
    }
}
