package swea_java;

import java.util.Arrays;
import java.util.Scanner;

public class ex1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();
			int [] arr = new int[100];
			
			for(int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i = 0; i < dump; i++) {
				Arrays.sort(arr);
				arr[0] +=1;
				arr[99] -=1;
			}
			Arrays.sort(arr);
			int ret = arr[99]- arr[0];
			System.out.println("#"+tc+" "+ret);
		}

	}
}
