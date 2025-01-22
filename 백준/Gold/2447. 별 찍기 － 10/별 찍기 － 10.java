import java.io.*;
import java.util.*;

public class Main {
	static char map[][];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new char[n][n];
		divideStar(0, 0, n, false);
		printStar(n);
		
	}

	static void divideStar(int row, int col, int num, boolean state) {
		if (state) {
			for (int i = row; i < row + num; i++) {
				for (int j = col; j < col + num; j++) {
					map[i][j] = ' ';
				}
			}
			return;
		}
		
		if (num == 1) {
			map[row][col] = '*';
			return;
		}
		
		int cnt = 0;
		int newSize = num / 3;
		for (int i = row; i < row + num; i += newSize) {
			for (int j = col; j < col + num; j += newSize) {
				cnt += 1;
				if (cnt == 5) {
					divideStar(i, j, newSize, true);
				} else {
					divideStar(i, j, newSize, false);
				}
			}
		}
	}

	static void printStar(int num) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}