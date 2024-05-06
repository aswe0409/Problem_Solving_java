import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char [][] arr;
	static int n;
	static boolean [][] visit;
	static int state = 0; // 0이면 탈출 실패, 1이면 탈출 성공
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new char[n][n];
		visit = new boolean[n][n];
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = st.nextToken().charAt(0);
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j <n; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		combi(0);
		if(state == 1) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	
	static void combi(int cnt) {
        if(cnt == 3) {
            if (search()) {
                state = 1;
            }
            return;
        }
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 'X' && !visit[i][j]) {
					arr[i][j] = 'O';
					visit[i][j] = true;
					combi(cnt+1);
					arr[i][j] = 'X';
					visit[i][j] = false;
				}
			}
		}
	}
	
	 static boolean search() {
	        for(int i = 0; i < n; i++) {
	            for(int j = 0; j < n; j++) {
	                if(arr[i][j] == 'T') {
	                    if (!isSafe(i, j)) {
	                        return false;
	                    }
	                }
	            }
	        }
	        return true;
	    }

	    static boolean isSafe(int x, int y) {
	        // 상
	        for (int i = x - 1; i >= 0; i--) {
	            if (arr[i][y] == 'O') break;
	            if (arr[i][y] == 'S') return false;
	        }

	        // 하
	        for (int i = x + 1; i < n; i++) {
	            if (arr[i][y] == 'O') break;
	            if (arr[i][y] == 'S') return false;
	        }

	        // 좌
	        for (int j = y - 1; j >= 0; j--) {
	            if (arr[x][j] == 'O') break;
	            if (arr[x][j] == 'S') return false;
	        }

	        // 우
	        for (int j = y + 1; j < n; j++) {
	            if (arr[x][j] == 'O') break;
	            if (arr[x][j] == 'S') return false;
	        }

	        return true;
	    }
	
	static void printMap() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}