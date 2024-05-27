import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class Tank {
        int row, col, dir;

        Tank(int row, int col, int dir) {
            this.row = row;
            this.col = col;
            this.dir = dir; // 1: 왼쪽, 2: 위, 3: 오른쪽, 4: 아래
        }
    }

    static int h, w;
    static char[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            Tank tank = null;
            arr = new char[h][w];
            for (int i = 0; i < h; i++) {
                String temp = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c1 = temp.charAt(j);
                    if (c1 == '<') {
                        tank = new Tank(i, j, 1);
                        arr[i][j] = '.';
                    } else if (c1 == '^') {
                        arr[i][j] = '.';
                        tank = new Tank(i, j, 2);
                    } else if (c1 == '>') {
                        arr[i][j] = '.';
                        tank = new Tank(i, j, 3);
                    } else if (c1 == 'v') {
                        arr[i][j] = '.';
                        tank = new Tank(i, j, 4);
                    } else {
                        arr[i][j] = c1;
                    }
                }
            }

            int n = Integer.parseInt(br.readLine());
            String order = br.readLine();

            for (int i = 0; i < order.length(); i++) {
                char command = order.charAt(i);
                if (command == 'S') {
                    shoot(tank);
                } else {
                    move(tank, command);
                }
            }

            // 탱크의 최종 위치와 방향 업데이트
            switch (tank.dir) {
                case 1:
                    arr[tank.row][tank.col] = '<';
                    break;
                case 2:
                    arr[tank.row][tank.col] = '^';
                    break;
                case 3:
                    arr[tank.row][tank.col] = '>';
                    break;
                case 4:
                    arr[tank.row][tank.col] = 'v';
                    break;
            }

            System.out.print("#" + test + " ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }
    }

    static void shoot(Tank tank) {
        int i = 1;
        // 왼쪽으로 발사
        if (tank.dir == 1) {
            while (true) {
                int newj = tank.col - i;
                if (newj < 0) {
                    return;
                }
                if (arr[tank.row][newj] == '#') {
                    return;
                }
                if (arr[tank.row][newj] == '*') {
                    arr[tank.row][newj] = '.';
                    return;
                }
                i++;
            }
        }
        // 위로 발사
        else if (tank.dir == 2) {
            while (true) {
                int newi = tank.row - i;
                if (newi < 0) {
                    return;
                }
                if (arr[newi][tank.col] == '#') {
                    return;
                }
                if (arr[newi][tank.col] == '*') {
                    arr[newi][tank.col] = '.';
                    return;
                }
                i++;
            }
        }
        // 오른쪽으로 발사
        else if (tank.dir == 3) {
            while (true) {
                int newj = tank.col + i;
                if (newj >= w) {
                    return;
                }
                if (arr[tank.row][newj] == '#') {
                    return;
                }
                if (arr[tank.row][newj] == '*') {
                    arr[tank.row][newj] = '.';
                    return;
                }
                i++;
            }
        }
        // 아래로 발사
        else if (tank.dir == 4) {
            while (true) {
                int newi = tank.row + i;
                if (newi >= h) {
                    return;
                }
                if (arr[newi][tank.col] == '#') {
                    return;
                }
                if (arr[newi][tank.col] == '*') {
                    arr[newi][tank.col] = '.';
                    return;
                }
                i++;
            }
        }
    }

    static void move(Tank tank, char command) {
        if (command == 'U') {
            tank.dir = 2;
            if (tank.row - 1 >= 0 && arr[tank.row - 1][tank.col] == '.') {
                tank.row--;
            }
        } else if (command == 'D') {
            tank.dir = 4;
            if (tank.row + 1 < h && arr[tank.row + 1][tank.col] == '.') {
                tank.row++;
            }
        } else if (command == 'L') {
            tank.dir = 1;
            if (tank.col - 1 >= 0 && arr[tank.row][tank.col - 1] == '.') {
                tank.col--;
            }
        } else if (command == 'R') {
            tank.dir = 3;
            if (tank.col + 1 < w && arr[tank.row][tank.col + 1] == '.') {
                tank.col++;
            }
        }
    }
}