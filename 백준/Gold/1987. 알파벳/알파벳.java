import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int R, C;
    static char[][] arr;
    static boolean[][] visited;
    static boolean[] alpa;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = br.readLine().split(" ");
        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        arr = new char[R][C];
        visited = new boolean[R][C];
        alpa = new boolean[26]; // A-Z까지 방문 여부를 체크하는 배열
        
        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = row.charAt(j);
            }
        }
        
        dfs(0, 0, 0);
        System.out.println(maxCount);
    }
    
    private static void dfs(int row, int col, int count) {
        if (row < 0 || row >= R || col < 0 || col >= C) return; // 범위를 벗어남
        if (visited[row][col] || alpa[arr[row][col] - 'A']) return; // 이미 방문했거나 알파벳을 사용
        
        visited[row][col] = true; 
        alpa[arr[row][col] - 'A'] = true; // 현재 알파벳 사용 처리
        maxCount = Math.max(maxCount, count + 1); // 최대 칸 수 갱신
        
        for (int i = 0; i < 4; i++) {
            dfs(row + di[i], col + dj[i], count + 1);
        }
        
        visited[row][col] = false;
        alpa[arr[row][col] - 'A'] = false;
    }
}