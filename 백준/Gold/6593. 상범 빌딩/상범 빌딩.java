import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int height, row, col, time;
        Pos(int height, int row, int col, int time) {
            this.height = height;
        	this.row = row;
            this.col = col;
            this.time = time;
        }
    }

	static int [] di = {-1,1,0,0,0,0}; //동 서 남 북 상 하
	static int [] dj = {0,0,1,-1,0,0};
	static int [] dz = {0,0,0,0,1,-1};
    static char[][][] map;
    static boolean[][][] visit;
    static int L, R, C;
    static Queue<Pos> q;
	static int startl, startr, startc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); // 층
            R = Integer.parseInt(st.nextToken()); // 행
            C = Integer.parseInt(st.nextToken()); // 열

            if (L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            visit = new boolean[L][R][C];
            q = new LinkedList<>();


            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char temp = line.charAt(k);
                        if (temp == 'S') {
                            startl = i;
                            startr = j;
                            startc = k;
                        }
                        map[i][j][k] = temp;
                    }
                }
                br.readLine(); // 빈 줄 읽기
            }
            q.add(new Pos(startl, startr, startc, 0));
            visit[startl][startr][startc] = true;

            int cnt = bfs();
            if (cnt < 0) {
            	System.out.println("Trapped!");
            } else {
            	System.out.println("Escaped in "+ cnt+" minute(s).");
            }
        }
    }

    static int bfs() {
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int d = 0; d < 6; d++) {
                int newl = cur.height + dz[d];
                int newr = cur.row + di[d];
                int newc = cur.col + dj[d];
                if (newl >= 0 && newl < L && newr >= 0 && newr < R && newc >= 0 && newc < C) {
                    if (map[newl][newr][newc] == 'E') {
                        return cur.time + 1;
                    }
                    if (map[newl][newr][newc] == '.' && !visit[newl][newr][newc]) {
                        q.offer(new Pos(newl, newr, newc, cur.time + 1));
                        visit[newl][newr][newc] = true;
                    }
                }
            }
        }
        return -1;
    }
}