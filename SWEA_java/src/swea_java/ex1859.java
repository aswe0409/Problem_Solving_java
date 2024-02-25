package swea_java;

import java.util.Scanner;

public class ex1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t =0; t < tc; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			long max_val = arr[arr.length-1];
			long ret = 0;
			
			for(int i = arr.length - 2; i >= 0; i--) {
				if(max_val < arr[i]) max_val = arr[i];
				else ret += max_val - arr[i]; 
			}
			
			System.out.println("#"+(t+1)+" "+ret);
		}
		
	}
}
