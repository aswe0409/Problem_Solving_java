import java.io.*;
import java.util.*;

public class Main {
	static int map[][];
	static int r,c;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int size = (int)Math.pow(2,n);
		divide(0,0,size);
	}
	static void divide(int row, int col, int size) {
		if(size == 2) {
			check(row, col, size);
		}
		
		else {
			int newSize = size / 2;
			if(r < row + newSize && c < col + newSize) {
				divide(row, col, newSize);
			}
			else if(r < row + newSize && c >= col + newSize) {
				cnt += newSize * newSize;
				divide(row, col+newSize, newSize);
			}
			
			else if(r >= row + newSize && c < col + newSize) {
				cnt += 2 * newSize * newSize;
				divide(row+newSize, col, newSize);
			}
			else {
				cnt += 3 * newSize * newSize;
				divide(row+newSize, col+newSize, newSize);
			}
		}
	}
	
	static void check(int row, int col, int size) {
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(i == r && j == c) {
					System.out.println(cnt);
					System.exit(0);
				}
				cnt+=1;
			}
		}
		return ;
	}
}