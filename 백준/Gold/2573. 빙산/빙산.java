import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int row, col;

        Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    static int n, m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            if (bfs() == 0) { // 모든 빙산이 녹았을 때
                time = 0;
                break;
            }
            time++;
            if (check()) { // 빙산이 분리되었을 때
                break;
            }
        }
        System.out.println(time);
    }

    static int bfs() {
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] copy_arr = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy_arr[i][j] = arr[i][j];
                if (arr[i][j] != 0) {
                    q.offer(new Pos(i, j));
                    visited[i][j] = true; // 방문 표시
                }
            }
        }

        int icebergs = 0; // 빙산의 개수를 세기 위한 변수

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int newi = cur.row + di[d];
                int newj = cur.col + dj[d];
                if (newi >= 0 && newi < n && newj >= 0 && newj < m && arr[newi][newj] == 0) {
                    copy_arr[cur.row][cur.col] -= 1;
                    if (copy_arr[cur.row][cur.col] < 0) {
                        copy_arr[cur.row][cur.col] = 0;
                    }
                }
            }
            if (copy_arr[cur.row][cur.col] != 0) { // 현재 위치가 빙산인 경우
                icebergs++;
            }
        }
        arr = copy_arr; // 원본 배열 업데이트
        return icebergs;
    }

    static boolean check() {
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    count++;
                    if (count > 1) { // 빙산이 두 개 이상인 경우
                        return true;
                    }
                    BFS(i, j, visited);
                }
            }
        }
        return false;
    }

    static void BFS(int row, int col, boolean[][] visited) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(row, col));
        visited[row][col] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int newi = cur.row + di[k];
                int newj = cur.col + dj[k];
                if (newi >= 0 && newi < n && newj >= 0 && newj < m && arr[newi][newj] != 0 && !visited[newi][newj]) {
                    q.offer(new Pos(newi, newj));
                    visited[newi][newj] = true;
                }
            }
        }
    }
}