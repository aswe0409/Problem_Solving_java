import java.util.*;
import java.io.*;

public class Main {
	static class Basket{
		int row, col, water, cloud;
		Basket(int row, int col, int water, int cloud){
			this.row = row;
			this.col = col;
			this.water = water; // 물의 양
			this.cloud = cloud; // 0 = 구름 없음, 1 = 구름 있음
		}
	}
	
	static int n, m;
	static Basket [][]arr;
	static int [] di = {0,-1,-1,-1,0,1,1,1};
	static int [] dj = {-1,-1,0,1,1,1,0,-1};
	static int [] di2 = {-1,-1,1,1}; //대각선
	static int [] dj2 = {-1,1,1,-1}; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new Basket[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if((i == n && j == 1) || (i == n && j == 2) || (i == n-1 && j == 1) ||(i == n-1 && j == 2)) {
					arr[i][j] = new Basket(i,j,temp,1);
				}
				else {
					arr[i][j] = new Basket(i,j,temp,0);
				}
			}
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int space = Integer.parseInt(st.nextToken());
			move(dir, space); // 1. 이동
			increase(); // 2,3 구름 칸 바구니 물양 증가, 구름 사라짐
			makeCloud(); // 5. 구름 생성
		}

		int ret = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				ret += arr[i][j].water;
			}
		}
		System.out.println(ret);
	}
	
	// 1. d 방향으로 s 칸 이동
    static void move(int dir, int space) {
        // 새 구름 위치를 저장할 배열 (임시)
        int[][] newCloud = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j].cloud == 1) {
                    // 현재 구름 위치 (i,j)를 기준으로 이동
                    int newi = ((i - 1 + di[dir-1] * space) % n + n) % n + 1;
                    int newj = ((j - 1 + dj[dir-1] * space) % n + n) % n + 1;
                    newCloud[newi][newj] = 1;
                }
            }
        }
        // 기존 구름 상태를 새로운 구름 상태로 갱신
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j].cloud = newCloud[i][j];
            }
        }
    }
	
	//2,3 물 주고 구름 사라짐, 
	static void increase() {
		int [][] copyArr = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(arr[i][j].cloud == 1) {
					arr[i][j].cloud = 2;
					arr[i][j].water +=1;
				}
			}
		}
		
		// 4. 물 증가한 칸 물 복사
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(arr[i][j].cloud == 2) {
					int cnt = magic(i,j); 
					copyArr[i][j] = cnt;
				}
			}
		}
		
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <=n; j++) {
				arr[i][j].water += copyArr[i][j];
			}
		}
	}
	
	//4. 물 복사 버그
	static int magic(int nowi, int nowj) {
		int cnt = 0;
		for(int d = 0; d < 4; d++) {
			int newi = nowi + di2[d];
			int newj = nowj + dj2[d];
			
			if(newi > 0 && newi <= n && newj > 0 && newj <= n && arr[newi][newj].water >= 1) {
				cnt +=1;
			}
		}
		return cnt;
	}
	
	//5. 구름 생성
	static void makeCloud() {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(arr[i][j].water >= 2 && arr[i][j].cloud != 2) {
					arr[i][j].cloud = 1;
					arr[i][j].water -= 2;
				}
				if(arr[i][j].cloud == 2) {
					arr[i][j].cloud = 0;
				}
			}
		}
	}
	
	static void printMap() {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(arr[i][j].water+" ");
			}
			System.out.println();
		}
	}
}