package swea_java;

import java.util.Arrays;
import java.util.Scanner;

public class ex13038 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int target = sc.nextInt();
			int[] arr = new int[7];
			
			for (int i = 0; i < 7; i++) {
				arr[i] = sc.nextInt();
			}
			
			int[] ret = new int[7];
			
			for(int j = 0; j<7;j++) {
				int stay = 0;
				int attend = 0;
				int idx = 7+j;
				
				while (true) {
					if (arr[idx % 7] == 1) {
						attend += 1;
						stay += 1;
						idx += 1;
					} 
					
					else {
						stay += 1;
						idx += 1;
					}
					
					if (attend == target)
						
						break;
				}
				ret[j] = stay;
			}
			Arrays.sort(ret);
			System.out.println("#" + tc + " " + ret[0]);
		}
	}
}
