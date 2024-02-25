package swea_java;

import java.util.Scanner;

public class ex1210 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		
		for(int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			
			int[][] arr = new int[100][100];
			int s_i = 0;
			int s_j = 0;
			int ret = 0;
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 2) {
						s_i = i;
						s_j =j;
					}
				}
			}
				//위로 가기
			int nowi  = s_i, nowj = s_j;
			while(true) {
				if(nowi ==0) { // i가 맨 위에 도착하면 끝	
					break;
				}
				
				if(nowj-1 >= 0  && arr[nowi][nowj -1] == 1) { // left
					arr[nowi][nowj] = 0;
					nowj--;
				}
				else if(nowj +1 < 100 && arr[nowi][nowj+1] == 1) { // right
					arr[nowi][nowj] = 0;
					nowj++;
				}
				else { // up
					nowi--;
				}
			}
			ret = nowj;
			System.out.println("#"+t+ " "+ ret);
			}
		}// main	
	}// class
