import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int row, col, state; // 상태가 0 = 가로, 1 = 대각선, 2 = 세로

        public Pos(int row, int col, int state) {
            this.row = row;
            this.col = col;
            this.state = state;
        }
    }

    static int cnt; // 목표 지점 도달 개수 세기
    static int N;
    static int[][] arr;
    static Queue<Pos> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 1, 0); 
        System.out.println(cnt);
    }

    private static void bfs(int row, int col, int state) {
        q.offer(new Pos(row, col, state));

        while (!q.isEmpty()) {
            Pos temp = q.poll();
            if (temp.row == N - 1 && temp.col == N - 1) {
                cnt+=1;
                continue;
            }

            // 가로 이동
            if ((temp.state == 0 || temp.state == 1) && temp.col + 1 < N && arr[temp.row][temp.col + 1] == 0) {
                q.offer(new Pos(temp.row, temp.col + 1, 0));
            }

            // 세로 이동
            if ((temp.state == 2 || temp.state == 1) && temp.row + 1 < N && arr[temp.row + 1][temp.col] == 0) {
                q.offer(new Pos(temp.row + 1, temp.col, 2));
            }

            // 대각선 이동
            if (temp.row + 1 < N && temp.col + 1 < N
                    && arr[temp.row][temp.col + 1] == 0 && arr[temp.row + 1][temp.col] == 0
                    && arr[temp.row + 1][temp.col + 1] == 0) {
                q.offer(new Pos(temp.row + 1, temp.col + 1, 1));
            }
        }
    }
}