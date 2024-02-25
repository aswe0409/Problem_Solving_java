package swea_java;

import java.util.Scanner;

public class ex1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int[] di = {0,1,0,-1};
		int[] dj = {1,0,-1,0};
		
		for(int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int [][] arr = new int[n][n];
			int i = 0,j= 0,dir = 0;
			int num = 1;
			arr[i][j] = num;
			num +=1;
			
			while(num <= n*n) {
				int ni= i + di[dir];
				int nj = j + dj[dir];
				
				if(ni >= 0 && ni < n && nj >= 0 && nj < n && arr[ni][nj] == 0 ) {
					arr[ni][nj] = num;
					num+=1;
					i = ni;
					j = nj;
				}
				else {
					dir = (dir + 1) % 4;
				}
			}
			System.out.println("#"+tc);
			for(int a = 0; a < n; a++) {
				
				for(int b = 0; b < n; b++) {
					System.out.print(arr[a][b]+" ");
				}
				System.out.println();
			}
		}
	}
}
