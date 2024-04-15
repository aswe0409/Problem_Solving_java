import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Pos {
        int row, col;
        Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int time = 0; // 시간
        int last = 0; //남아 있는 치즈 count

        while (true) {
            last = countCheese();
            if (last == 0) break;

            bfs();
            meltCheese();
            time++;
        }

        System.out.println(time);
        sc.close();
    }

    private static void bfs() {
        visited = new boolean[N][M];
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0));  // 외부 공기로 시작
        visited[0][0] = true; //   여기는 무조건 true

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int newi = cur.row + dx[k];
                int newj = cur.col + dy[k];
                if (newi >= 0 && newi < N && newj >= 0 && newj < M && !visited[newi][newj]) {
                    if (map[newi][newj] == 0) {
                        queue.add(new Pos(newi, newj));
                        visited[newi][newj] = true;
                    }
                }
            }
        }

        // 외부 공기랑 몇개 닿아있는지 획인
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (map[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (visited[ni][nj]) cnt++;
                    }
                    if (cnt >= 2) map[i][j] = 2; //2개 이상이면 녹일 준비
                }
            }
        }
    }

    private static void meltCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int countCheese() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }
}