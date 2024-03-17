package baekjoon_java;

import java.util.Scanner;

public class BOJ14890_경사로 {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (checkRow(i)) cnt++;
            if (checkCol(i)) cnt++;
        }
        System.out.println(cnt);
    }


    static boolean checkRow(int row) {
        boolean[] visited = new boolean[N];// 경사로 세운거 판별
        for (int i = 0; i < N - 1; i++) {
            if (map[row][i] == map[row][i + 1]) continue;  //앞에 값이랑 높이가 동일 할 때
            
            if (Math.abs(map[row][i] - map[row][i + 1]) > 1) return false; // 옆에 값이랑 차이가 2이상 일 때
            
            if (map[row][i] - map[row][i + 1] == 1) { // 옆에 값이랑 차이가 1이면 내리막 경사로
                for (int j = i + 1; j <= i + L; j++) { // 연속 된 L 칸 만큼 체크 i + 1 부터 시작하는 이유는 옆에 칸에 내리막 경사로를 설치해야 하기 때문
                   // 인덱스 벗어 나는지, 경사로 놓을 연속된 곳이 동일 한 값을 갖는지 ,이미 경사로가 설치 되어 있는지
                	if (j >= N || map[row][j] != map[row][i + 1] || visited[j]) return false;
                    visited[j] = true;
                }
            } 
            else if (map[row][i + 1] - map[row][i] == 1) { // 오르막 경사로
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || map[row][j] != map[row][i] || visited[j]) return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }

    static boolean checkCol(int col) {
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            if (map[i][col] == map[i + 1][col]) continue;
            
            if (Math.abs(map[i][col] - map[i + 1][col]) > 1) return false;
            
            if (map[i][col] - map[i + 1][col] == 1) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || map[j][col] != map[i + 1][col] || visited[j]) return false;
                    visited[j] = true;
                }
            } 
            else if (map[i + 1][col] - map[i][col] == 1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || map[j][col] != map[i][col] || visited[j]) return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}
