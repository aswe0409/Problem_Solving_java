import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Pos{
		int row, col, cnt;
		public Pos(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
	static int w;
	static int h;
	static int starti;
	static int startj;
	static char[][] map;
	static int []di = {0,0,1,-1}; // 우 좌 하 상
	static int []dj = {1,-1,0,0};
	static Queue<Pos> q;
	static Queue<Pos> peopelq;
	static int state; // 0이면 실패, 1이면 탈출
	static int ret;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int test = 0; test < tc; test++) {
            String[] str = br.readLine().split(" ");
            w = Integer.parseInt(str[0]);
            h = Integer.parseInt(str[1]);
			map = new char [h][w];
			q = new LinkedList<>();
			peopelq = new LinkedList<>();
			state = 0;
			ret = 0;
			visited = new boolean[h][w];

		    for (int i = 0; i < h; i++) {
		        String line = br.readLine();
		        for (int j = 0; j < w; j++) {
		            map[i][j] = line.charAt(j);
		            if (map[i][j] == '*') {
		                q.offer(new Pos(i, j, 0));
		            } else if (map[i][j] == '@') {
		                peopelq.offer(new Pos(i, j, 0));
		                visited[i][j] = true; 
		            }
		        }
		    }
	        while (!peopelq.isEmpty() && state == 0) {
			    fire();
			    escape();
	        }

		    
            if(state == 1) {
            	System.out.println(ret);
            }
            else {
            	System.out.println("IMPOSSIBLE");
            }

		}

	}
	
	private static void fire() {
	    int size = q.size(); //불의 개수만큼만 처리
	    for (int i = 0; i < size; i++) {
	        Pos temp = q.poll();
	        for (int k = 0; k < 4; k++) {
	            int newi = temp.row + di[k];
	            int newj = temp.col + dj[k];

	            if (newi >= 0 && newi < h && newj >= 0 && newj < w && map[newi][newj] == '.') {
	                map[newi][newj] = '*';
	                q.offer(new Pos(newi, newj, temp.cnt + 1));
	            }
	        }
	    }
	}
	
	private static void escape() {
	    int size = peopelq.size(); // 현재 큐에 있는 사람의 위치 개수만큼만 처리
	    for (int i = 0; i < size; i++) {
	        if (state == 1) break; // 탈출 하면 stop 그래야 최소값 나옴

	        Pos temp = peopelq.poll();
	        for (int k = 0; k < 4; k++) {
	            int newi = temp.row + di[k];
	            int newj = temp.col + dj[k];

	            // 탈출 했는지 체크
	            if (newi < 0 || newi >= h || newj < 0 || newj >= w) {
	                state = 1; // 탈출 성공
	                ret = temp.cnt + 1;
	                return;
	            }

	            
	            if (newi >= 0 && newi < h && newj >= 0 && newj < w && map[newi][newj] == '.' && !visited[newi][newj]) {
	                visited[newi][newj] = true;
	                peopelq.offer(new Pos(newi, newj, temp.cnt + 1));
	            }
	        }
	    }
	}
}