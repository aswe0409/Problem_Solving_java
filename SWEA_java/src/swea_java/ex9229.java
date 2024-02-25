package swea_java;

import java.util.Scanner;

public class ex9229 {
	static int n, m, sum;
	static int [] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc = 1; tc <= TC; tc++) {
			n = sc.nextInt(); //과자 개수
			m = sc.nextInt(); // 과자 무ㅡ게
			arr = new int[n];
			sum = -1;
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			comb(0,0,0);
			System.out.println("#"+tc+" "+ sum);
			
		}
	}
	
    private static void comb(int cnt, int start, int weight) {
        if (cnt == 2) {
            sum = Math.max(weight, sum);
            return;
        }

        for (int i = start; i < n; i++) {
            if (weight + arr[i] <= m) {
                comb(cnt + 1, i + 1, weight + arr[i]);
            }
        }
    }
}
