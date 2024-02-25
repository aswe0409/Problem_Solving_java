package baekjoon_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex15686 {
	static List<Integer> arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N * N 크기 배열
		int M = sc.nextInt(); // 최대 치킨집 개수
		arr = new ArrayList<Integer>(); // 각 집에서 치킨집 까지 최소값 담아줄 리스트
		
		int [][]map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					
				}
			}
			System.out.println();
		}
	}
	
	private static void pick() {
		
	}
}
