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
    
    static int n, m; // m = 바이러스의 개수
    static int[][] arr;
    static int[][] tempMap;
    static Queue<Pos> q;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int minTime = Integer.MAX_VALUE;
    static boolean [][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = new LinkedList<>();
        arr = new int[n][n];
        
        tempMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        combi(0, 0);
        if (minTime == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minTime);
        }
    }

    static void combi(int start, int cnt) {
        if (cnt == m) {
            copyMap();
            spread();
            return;
        } else {
            for (int i = start; i < n * n; i++) {
                int row = i / n;
                int col = i % n;
                if (arr[row][col] == 2) {
                    arr[row][col] = 3;
                    combi(i , cnt + 1);
                    arr[row][col] = 2;
                }
            }
        }
    }

    static void copyMap() {
    	visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempMap[i][j] = arr[i][j];
                if (arr[i][j] == 3) {
                    q.offer(new Pos(i, j));
                    visit[i][j] = true;
                }
            }
        }
    }

    static void spread() {
        int[][] time = new int[n][n];
        
        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int newi = cur.row + dx[d];
                int newj = cur.col + dy[d];

                if (newi >= 0 && newi < n && newj >= 0 && newj < n && tempMap[newi][newj] != 1 &&tempMap[newi][newj] != 3 && !visit[newi][newj]) {
                    tempMap[newi][newj] = 3;
                    time[newi][newj] = time[cur.row][cur.col] + 1;
                    q.offer(new Pos(newi, newj));
                    visit[newi][newj] = true;
                }
            }
        }
//        for(int i = 0; i < n; i++) {
//        	for(int j = 0; j <n; j++) {
//        		System.out.print(time[i][j]+" ");
//        	}
//        	System.out.println();
//        }
//        System.out.println();
        checkMap(time);
    }

    static void checkMap(int[][] time) {
        int maxTime = 0;
        boolean state = true;  // 모든 빈 칸이 감염되었는지 추적

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 바이러스가 도달하지 못한 빈 칸이 있으면
                if (tempMap[i][j] == 0 || tempMap[i][j] == 2) {
                	state = false;
                    return;
                }
                // 바이러스가 도달한 경우 시간을 확인하여 최대 시간 갱신
                if (tempMap[i][j] == 3) {
                    maxTime = Math.max(maxTime, time[i][j]);
                }
            }
            if (!state) break;  // 이미 빈 칸이 발견되면 루프 중단
        }

        // 모든 빈 칸에 바이러스가 퍼졌다면 최소 시간 갱신
        if (state) {
            minTime = Math.min(minTime, maxTime);
        }
    }
    static void printMap() {
    	for(int i = 0; i < n; i++) {
    		for(int j =0; j < n; j++) {
    			System.out.print(tempMap[i][j]+" ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}