import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int row, col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, M;
    static char[][] arr;
    static boolean[][] visited;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];
        int enemy = 0, team = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine().replace(" ","");
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'W' && !visited[i][j]) { // 우리팀
                    team += (int) Math.pow(bfs(i, j, 'W'), 2);
                } else if (arr[i][j] == 'B' && !visited[i][j]) { // 상대 팀
                    enemy += (int) Math.pow(bfs(i, j, 'B'), 2);
                }
            }
        }
        System.out.println(team + " " + enemy);
    }

    static int bfs(int nowi, int nowj, char c) {
        visited[nowi][nowj] = true;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(nowi, nowj));
        int cnt = 0;
        while (!q.isEmpty()) {
            Pos temp = q.poll();
            for (int d = 0; d < 4; d++) {
                int newi = temp.row + di[d];
                int newj = temp.col + dj[d];
                if (newi >= 0 && newi < N && newj >= 0 && newj < M && arr[newi][newj] == c && !visited[newi][newj]) {
                    visited[newi][newj] = true;
                    q.add(new Pos(newi, newj));
                }
            }
            cnt +=1;
        }
        return cnt;
    }
}