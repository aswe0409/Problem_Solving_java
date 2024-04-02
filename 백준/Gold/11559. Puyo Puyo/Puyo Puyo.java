import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static class Pos{
        int row, col;
        Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static int ans = 0;
    static char [][]arr = new char[12][6];
    static int [] di = {1,-1,0,0};
    static int [] dj = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i <12; i++) {
            String line = br.readLine();
            for(int j = 0; j <6; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        boolean popped;
        do {
            popped = false;
            boolean [][] visited = new boolean[12][6];
            for(int i = 0; i <12; i++) {
                for(int j = 0; j <6; j++) {
                    if(arr[i][j] != '.' && !visited[i][j]) {
                        if(bfs(i, j, arr[i][j], visited)) {
                            popped = true;
                        }
                    }
                }
            }
            if (popped) {
                ans++;
                move();
            }
        } while(popped);
        
        System.out.println(ans);
    }

    static boolean bfs(int row, int col, char color, boolean[][] visited) {
        Queue<Pos> queue = new LinkedList<>();
        List<Pos> toPop = new ArrayList<>();
        queue.add(new Pos(row, col));
        visited[row][col] = true;
        toPop.add(new Pos(row, col));

        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            for(int d = 0; d < 4; d++) {
                int nr = p.row + di[d];
                int nc = p.col + dj[d];
                if(nr >= 0 && nr < 12 && nc >= 0 && nc < 6 && !visited[nr][nc] && arr[nr][nc] == color) {
                    queue.add(new Pos(nr, nc));
                    visited[nr][nc] = true;
                    toPop.add(new Pos(nr, nc));
                }
            }
        }
        
        if (toPop.size() >= 4) {
            for (Pos p : toPop) {
                arr[p.row][p.col] = 'x';
            }
            return true;
        }
        return false;
    }

    static void move() {
        for (int col = 0; col < 6; col++) {
            for (int row = 11; row >= 0; row--) {
                if (arr[row][col] == 'x') {
                    for (int k = row; k >= 0; k--) {
                        if (arr[k][col] != 'x') {
                            arr[row][col] = arr[k][col];
                            arr[k][col] = 'x';
                            break;
                        }
                    }
                }
            }
            for (int row = 11; row >= 0; row--) {
                if (arr[row][col] == 'x') {
                    arr[row][col] = '.';
                }
            }
        }
    }
}