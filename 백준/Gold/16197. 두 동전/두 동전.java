import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Coin {
		int r1, c1, r2, c2, state1, state2;

		public Coin(int r1, int c1, int r2, int c2, int state1, int state2) {
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
			this.state1 = state1; // 1이면 탈출
			this.state2 = state2;
		}
	}

	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static char[][] arr;
	static int n, m;
	static Queue<Coin> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new char[n][m];
		int cnt = 0;
		int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = line.charAt(j);
				if (arr[i][j] == 'o') {
					if (cnt == 0) {
						r1 = i;
						c1 = j;
						cnt++;
					} else if (cnt == 1) {
						r2 = i;
						c2 = j;
					}
				}
			}
		}
		Coin coin = new Coin(r1, c1, r2, c2, 0, 0);
		q.offer(coin);
		System.out.println(bfs());
	}

	static int bfs() {
	    int depth = 0; // 이동 횟수를 측정하는 변수
	    while (!q.isEmpty()) {
	        int size = q.size();
	        for (int i = 0; i < size; i++) {
	            Coin cur = q.poll();
	            
	            if (depth >= 10) { // 10번 이상 버튼을 눌러야 한다면 -1 반환
	                return -1;
	            }
	            
	            for (int d = 0; d < 4; d++) {
	                int newi1 = cur.r1 + di[d];
	                int newj1 = cur.c1 + dj[d];
	                int newi2 = cur.r2 + di[d];
	                int newj2 = cur.c2 + dj[d];
	                
	                boolean out1 = false, out2 = false;
	                
	                // 첫 번째 동전 이동 처리
	                if (newi1 < 0 || newi1 >= n || newj1 < 0 || newj1 >= m) {
	                    out1 = true; // 보드 밖으로 나감
	                } else if (arr[newi1][newj1] == '#') {
	                    newi1 = cur.r1;
	                    newj1 = cur.c1; // 벽이므로 위치 유지
	                }
	                
	                // 두 번째 동전 이동 처리
	                if (newi2 < 0 || newi2 >= n || newj2 < 0 || newj2 >= m) {
	                    out2 = true; // 보드 밖으로 나감
	                } else if (arr[newi2][newj2] == '#') {
	                    newi2 = cur.r2;
	                    newj2 = cur.c2; // 벽이므로 위치 유지
	                }
	                
	                // 한 동전만 보드 밖으로 떨어지는 경우
	                if (out1 && !out2 || !out1 && out2) {
	                    return depth + 1; // 현재 이동 횟수를 반환
	                }
	                
	                // 두 동전 모두 보드에 남아있는 경우
	                if (!out1 && !out2) {
	                    q.offer(new Coin(newi1, newj1, newi2, newj2, 0, 0));
	                }
	            }
	        }
	        depth++;
	    }
	    return -1; // 조건을 만족하는 해가 없는 경우
	}

}