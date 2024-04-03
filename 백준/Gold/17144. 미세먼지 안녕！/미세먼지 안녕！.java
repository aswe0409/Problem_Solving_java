import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos{
		int row, col, monji;
		Pos(int row, int col, int monji){
			this.row = row;
			this.col = col;
			this.monji = monji;
		}
	}
	static int r,c,t;
	static int [] di = {0,0,-1,1};
	static int [] dj = {1,-1,0,0};
	static int [][] arr;
	static Queue<Pos> q;
	static int loc = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		arr = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					loc += i;

				}
			}
		}
//		for(int i = 0; i < r; i++) {
//			for(int j = 0; j < c; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		//1. 배열 완탐으로 미세 먼지 있는 곳 찾아서 큐에 넣어 왜냐면 동시에 퍼트릴꺼니까!!!!!
		for(int k = 0; k < t; k++) {
			q = new LinkedList<>();
			for(int i = 0; i < r; i++) {
				for(int j = 0; j <c; j++) {
					if(arr[i][j] != 0) {
						q.offer(new Pos(i,j,arr[i][j]));
					}
				}
			}
			spread();
			airClean();
		}
		int ans = count();
		System.out.println(ans);
	}
	
	static int count() {
		int ret = 0;
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(arr[i][j] != -1) {
					ret += arr[i][j];
				}
			}
		}
		return ret;
	}
	
	static void airClean() {
		int top = loc /2;
		int[][] temp_arr = new int[r][c];
		//공기 청정기 아래 (시계방항) 
		//윗줄
		for(int i = 1; i < c; i++) {
			if(arr[top+1][i-1] == -1) {
				temp_arr[top+1][i] = 0; // 공기 청정기 옆은 무조건 0
			}
			else {
				temp_arr[top+1][i] = arr[top+1][i-1];	
			}
		}
		//오른쪽 줄
		for(int i = top+2; i < r; i++) {
			temp_arr[i][c-1] = arr[i-1][c-1];
		}
		// 맨 아래 줄
		for(int i = c-2; i >=0 ; i--) {
			if(arr[r-1][0] != -1) {
				temp_arr[r-1][i] = arr[r-1][i+1];
			}
		}
		
		//맨 왼쪽 줄
		for(int i = r-2; i > top+1; i--) {
			if(arr[i][0] != -1) {
				temp_arr[i][0] = arr[i+1][0];
			}
		}
		
		/////////////////////////////////////////////////////
		//공기 청정기 윗 부분
		for(int i = c-2; i >= 0; i--) {
			if(arr[0][0] != -1) {
				temp_arr[0][i] = arr[0][i+1];
			}
		}
		
		//오른쪽 줄
		for(int i = top; i >= 0; i--) {
			temp_arr[i][c-1] = arr[i+1][c-1];
		}
		// 맨 아래 줄
		for(int i = 1; i < c; i++) {
			if(arr[top][i-1] == -1) {
				temp_arr[top+1][i] = 0; // 공기 청정기 옆은 무조건 0
			}
			else {
				temp_arr[top][i] = arr[top][i-1];	
			}
		}
		
		//맨 왼쪽 줄(수정 중)
		for(int i = 1; i < top; i++) {
				temp_arr[i][0] = arr[i-1][0];
			
		}
		
		 //가운데 값
		for(int i = 1; i < top; i++) {
			for(int j = 1; j < c-1; j++) {
				temp_arr[i][j] = arr[i][j];
			}
		}
		
		for(int i = top+2; i < r-1; i++) {
			for(int j = 1; j < c-1; j++) {
				temp_arr[i][j] = arr[i][j];
			}
		}
		//배열 복사
		for(int a = 0; a < r; a++) {
			for(int b = 0; b < c; b++) {
				if(arr[a][b] != -1) {
					arr[a][b] = temp_arr[a][b];
				}
			}
		}
			
//		for(int i = 0; i < r; i++) {
//		for(int j = 0; j <c; j++) {
//			System.out.print(temp_arr[i][j]+" ");
//		}
//		System.out.println();
//	}
		//printmap();
		
		
	}
	
	static void spread() {
		int size = q.size();
		
		int [][] temp_arr = new int[r][c];
		
		for(int i = 0; i < size; i++) {
			Pos now = q.poll();
			int cnt  = 0; //확산된 방향 순서 기록
			for(int d = 0; d <4; d++) {
				int newi = now.row + di[d];
				int newj = now.col + dj[d];
				//배열 범위에서 안 벗어 나고 공기청정기가 설치 안 되어 있으면 확산
				if(newi >= 0 && newi < r && newj >= 0 && newj < c && arr[newi][newj] != -1) {
					temp_arr[newi][newj] += now.monji / 5;
					cnt+=1;
				}
			}
			temp_arr[now.row][now.col] = now.monji -(now.monji /5 * cnt) + temp_arr[now.row][now.col];
		// 배열 복사
		}
		for(int a = 0; a < r; a++) {
			for(int b = 0; b < c; b++) {
				if(arr[a][b] != -1) {
					arr[a][b] = temp_arr[a][b];
				}
			}
		}
		
		//printmap();
	}
	
	static void printmap() {
		System.out.println("============================");
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("//////////////////////////////////");
	}
}