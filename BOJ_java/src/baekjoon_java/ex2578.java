package baekjoon_java;

import java.util.Scanner;

public class ex2578 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] bingo = new int[5][5];

		
		//bingo input
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <5; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < 25; i++) {
		    int cnt = 0;
		    int num = sc.nextInt();
		    for (int j = 0; j < 5; j++) {
		        for (int k = 0; k < 5; k++) {
		            if (bingo[j][k] == num) {
		                bingo[j][k] = 0;
		            }
		        }
		    }

		    // 가로 체크
		    for (int a = 0; a < 5; a++) {
		        int temp = 0;
		        for (int b = 0; b < 5; b++) {
		            if (bingo[a][b] == 0) {
		                temp += 1;
		            }
		        }
		        if (temp == 5) {
		            cnt += 1;
		        }
		    }

		    // 세로 체크
		    for (int a = 0; a < 5; a++) {
		        int temp = 0;
		        for (int b = 0; b < 5; b++) {
		            if (bingo[b][a] == 0) {
		                temp += 1;
		            }
		        }
		        if (temp == 5) {
		            cnt += 1;
		        }
		    }

		    // 대각선 체크
		    int ld_temp = 0;
		    for (int a1 = 0; a1 < 5; a1++) {
		        if (bingo[a1][a1] == 0) {
		            ld_temp += 1;
		        }
		    }
		    if (ld_temp == 5) {
		        cnt += 1;
		    }

		    int rd_temp = 0;
		    for (int a1 = 0; a1 < 5; a1++) {
		        if (bingo[a1][4 - a1] == 0) {
		            rd_temp += 1;
		        }
		    }
		    if (rd_temp == 5) {
		        cnt += 1;
		    }

		    if (cnt >= 3) {
		        System.out.println(i + 1);
		        return;
		    }
		}


				
	}//main
	
}//class

