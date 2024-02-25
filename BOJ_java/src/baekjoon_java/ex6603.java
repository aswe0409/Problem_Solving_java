package baekjoon_java;

import java.util.Scanner;

public class ex6603 {
	static int n;
	static int[] nums;
	static int[] ret;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			n = sc.nextInt();
			if(n == 0) return;
			
			nums = new int[n];
			ret = new int[6];
			
			for(int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			combi(0,nums[0]);
			System.out.println();
		}
	}
	
	static void combi(int idx, int start) {
		if(idx == 6) {
			for(int rets: ret) {
				System.out.print(rets+ " ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i = start; i <= nums.length; i++) {
				ret[idx] = nums[i-1];
				combi(idx +1, i +1);
			}
		}
	}
}
