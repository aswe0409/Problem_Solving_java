import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        if (N == 1) {  // 1초 후의 상태는 초기 상태 그대로
            printMap(map);
            return;
        }
        else if (N % 2 == 0) {  // N이 짝수이면 모든 칸이 폭탄으로 가득 참
            fillBomb(map);
            printMap(map);
            return;
        }
        else {
            // N이 3 또는 5 등 홀수일 때
            char[][] tempMap = pang(map, R, C, di, dj);
            if (N % 4 == 3) {
                printMap(tempMap);
            }
            else {
                char[][] tempMap2 = pang(tempMap, R, C, di, dj);
                printMap(tempMap2);
            }
        }
    }

    // 폭탄 설치
    private static void fillBomb(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 'O';
            }
        }
    }

    // 폭발
    private static char[][] pang(char[][] map, int R, int C, int[] di, int[] dj) {
        char[][] newMap = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                newMap[i][j] = 'O'; // 모든 칸에 폭탄 설치
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    newMap[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int ni = i + di[d];
                        int nj = j + dj[d];
                        if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
                            newMap[ni][nj] = '.';
                        }
                    }
                }
            }
        }
        return newMap;
    }

    private static void printMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}