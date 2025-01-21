import java.io.*;
import java.util.*;

public class Main {
	static int minus = 0, zero = 0, plus = 0;
	static int n;
	static int [][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j< n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(0,0, n);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}
	
	static void divide(int row, int col, int length) {
		int target = map[row][col];
		if(check(row, col, length)) {
			if(target == -1) {
				minus +=1;
			}
			else if(target == 0) {
				zero +=1;
			}
			else {
				plus +=1;
			}
			return;
		}
		int newSize = length /3;
		for(int i = row; i < row + length; i+= newSize) {
			for(int j = col; j < col + length; j += newSize) {
				divide(i,j,newSize);
			}
		}
	}
	
	static boolean check(int row, int col, int length) {
		int target = map[row][col];
		
		for(int i = row; i < row + length; i++) {
			for(int j = col; j < col + length; j++) {
				if(target != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}