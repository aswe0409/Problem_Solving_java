import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int[] di = {0, 1, 0, -1}; // 방향: 오른쪽, 아래, 왼쪽, 위쪽
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        board = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1; // 사과 표시
        }

        int l = Integer.parseInt(br.readLine());
        Queue<Order> orders = new LinkedList<>();

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            orders.offer(new Order(sec, dir));
        }

        int ans = 0;
        int state = 0;
        Deque<Pos> snake = new LinkedList<>();
        snake.offer(new Pos(1, 1));
        board[1][1] = 2; // 뱀의 몸 표시

        while (true) {
            ans += 1;
            Pos head = snake.peekFirst();
            int newi = head.i + di[state];
            int newj = head.j + dj[state];

            // 벽이나 자기 자신과 충돌했는지 확인
            if (newi <= 0 || newj <= 0 || newi > n || newj > n || board[newi][newj] == 2) {
                System.out.println(ans);
                return;
            }

            // 사과가 있는지 확인
            if (board[newi][newj] == 1) {
                board[newi][newj] = 2;
                snake.offerFirst(new Pos(newi, newj));
            } else { // 사과가 없으면 꼬리 이동
                board[newi][newj] = 2;
                snake.offerFirst(new Pos(newi, newj));
                Pos tail = snake.pollLast();
                board[tail.i][tail.j] = 0;
            }

            // 방향 변환
            if (!orders.isEmpty() && orders.peek().sec == ans) {
                Order order = orders.poll();
                if (order.dir == 'L') {
                    state = (state + 3) % 4;
                } else {
                    state = (state + 1) % 4;
                }
            }
        }
    }

    static class Order {
        int sec;
        char dir;

        Order(int sec, char dir) {
            this.sec = sec;
            this.dir = dir;
        }
    }

    static class Pos {
        int i, j;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}