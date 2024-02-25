package baekjoon_java;

import java.util.Scanner;

public class ex2961 {
	static int N;
	static int[] sour;
	static int[] bitter;
	static boolean[] select;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		min = Integer.MAX_VALUE;

		N = sc.nextInt();
		select = new boolean[N];
		sour = new int[N];
		bitter = new int[N];
		for(int i = 0; i < N; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}
		subset(0,1,0);
		System.out.println(min);
	}
	
	static void subset(int idx, int pick_sour, int pick_bitter) { 
		if(idx == N) { 
			for(int i = 0; i < N; i++) {
				if(select[i]) {
					min = Math.min(min, Math.abs(pick_sour - pick_bitter));
				}
			}
			return;
		}
		select[idx] = true; 
		subset(idx+1, sour[idx] * pick_sour, bitter[idx] + pick_bitter); // 골랏을때 
		select[idx] = false; 
		subset(idx+1, pick_sour, pick_bitter); // 안골랏을때
	}
}
