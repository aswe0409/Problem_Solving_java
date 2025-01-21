import java.io.*;
import java.util.*;

public class Main {
	static int [][] map;
	static int white = 0, blue = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(0,0,n);
		
		System.out.println(white);
		System.out.println(blue);
	}
	static void divide(int row, int col, int length) {
		if(check(row, col, length)) {
			if(map[row][col] == 0) {
				white +=1;
			}
			else {
				blue +=1;
			}
			return;
		}
		int newSize = length /2;
		divide(row, col, newSize);
		divide(row, col+newSize, newSize);
		divide(row+newSize, col, newSize);
		divide(row + newSize, col + newSize, newSize);
	}
	
	static boolean check(int row, int col, int size) {
		int target = map[row][col];
		
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(map[i][j] != target) {
					return false; //아직 다 안 나뉨
				}
			}
		}
		return true; // 다 나눔 다 눳으니까 개수 count
	}
}