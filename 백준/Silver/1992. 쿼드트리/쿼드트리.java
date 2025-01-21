import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int [][] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = line.charAt(j) -'0';
			}
		}
		divide(0,0,n);
		System.out.println(sb.toString());
	}
	static void divide(int row, int col, int length) {
		int target = arr[row][col];
		if(check(row, col, length)) {
			if(target == 0) {
				sb.append("0");
			}
			else {
				sb.append("1");
			}
			return;
		}
		
		int newSize = length / 2;
		sb.append('(');
		divide(row, col, newSize);
		divide(row, col+ newSize, newSize);
		divide(row + newSize, col, newSize);
		divide(row + newSize, col + newSize, newSize);
		sb.append(")");
	}
	static boolean check(int row, int col, int length) {
		int target = arr[row][col];
		
		for(int i = row; i < row + length; i++) {
			for(int j = col; j < col + length; j++) {
				if(target != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}