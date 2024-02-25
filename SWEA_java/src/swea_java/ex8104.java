package swea_java;

import java.util.Scanner;
public class ex8104 {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        for(int tc = 1; tc <= t; tc++) {
 
            int n = sc.nextInt();
            int k = sc.nextInt();
 
            int[][] arr = new int[n][k];
            int score = 1;
 
            for(int i = 0; i < n; i++) {
                if(i % 2 == 0) {
                    for(int j = 0; j < k; j++) {
                        arr[i][j] = score;
                        score++;
                    }
                }
                else {
                    for(int j = k-1; j >= 0; j--){
                        arr[i][j] = score;
                        score++;
                    }
                }
            }
 
            System.out.print("#" + tc + " ");
            for(int i = 0; i < k; i++){
                int sum = 0;
                for(int j = 0; j < n; j++){
                    sum+= arr[j][i];
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
//
//public class ex8104 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//
//		for (int tc = 1; tc <= t; tc++) {
//			int n = sc.nextInt();
//			int k = sc.nextInt();
//
//			// n * k == 짝수 이면 각 팀의 합이 같음
//			if ((n * k) % 2 == 0) {
//				int cnt = 1;
//				int temp = 0;
//				int sum = 0;
//				for (int i = 0; i < n; i++) {
//					if (cnt == 1) {
//						temp = temp + 1;
//						sum += temp;
//						cnt = 0;
//					} else {
//						temp = temp + (2 * k - 1);
//						sum += temp;
//						cnt = 1;
//					}
//
//				}
//				System.out.print("#" + tc);
//				for (int i = 0; i < k; i++) {
//					System.out.print(" " + sum);
//				}
//				System.out.println();
//			}
//			// n * k == 홀수 이면 맨 처음 팀 기준 ++
//			else {
//				int cnt = 1;
//				int temp = 0;
//				int sum = 0;
//				for (int i = 0; i < n; i++) {
//					if (cnt == 1) {
//						temp = temp + 1;
//						sum += temp;
//						cnt = 0;
//					} else {
//						temp = temp + (2 * k - 1);
//						sum += temp;
//						cnt = 1;
//					}
//
//				}
//				System.out.print("#" + tc);
//				for (int i = 0; i < k; i++) {
//					System.out.print(" " + sum);
//					sum+=1;
//				}
//				System.out.println();
//			}
//		}
//	}
//}

