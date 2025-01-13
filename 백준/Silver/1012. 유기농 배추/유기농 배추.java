import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos{
        int row, col;
        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int [][] arr;
    static Queue<Pos> q;
    static int [] di = {0,-1,0,1};
    static int [] dj = {1,0,-1,0};
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int test = 0; test < tc; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            q = new LinkedList<>();

            int cnt = 0;

            for(int i = 0; i < k; i++){
                StringTokenizer str = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(str.nextToken());
                int col = Integer.parseInt(str.nextToken());
                arr[row][col] = 1;
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] == 1){
                        cnt+=1;
                        bfs(i,j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int nowi, int nowj){
        q.offer(new Pos(nowi, nowj));

        while(!q.isEmpty()){
            Pos temp = q.poll();

            for(int d = 0; d < 4; d++) {
                int newi = temp.row + di[d];
                int newj = temp.col + dj[d];
                if (newi >= 0 && newi < n && newj >= 0 && newj < m && arr[newi][newj] == 1) {
                    arr[newi][newj] = 0;
                    q.offer(new Pos(newi, newj));
                }
            }
        }
    }
}