package baekjoon_java;

import java.util.Scanner;

public class ex15649 {
	static int N; // 총 개수
	static int M; // 선택할 개수
	static boolean[] select; // 선택 여부 판별
	static int[] card; // 선택 후보 배열
	static int[] ret; // 결과 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
        select = new boolean[N];
        card = new int[N];
        ret = new int[M];
		for(int i = 0; i < N; i++) {
			card[i] = i +1;
		}	
		perm(0);
	
	}
	private static void perm(int cnt) { //cnt 선택한 자리 수
		if(cnt == M) {
			for(int num:ret) {
				System.out.print(num+" ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i = 0; i < N; i++) {
				if(!(select[i])) {
					select[i] = true;
					ret[cnt] = card[i]; // 자기꺼 골랏으면
					perm(cnt+1); // 다음 자리 부르기
					select[i] = false; //다 햇으면 반납
				}
			}
		}
	}
}
