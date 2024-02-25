package baekjoon_java;

import java.util.Scanner;

public class ex1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int [] set = new int[10];
		
		for(int i =0; i<str.length(); i++) {
			int temp = str.charAt(i)-'0';
			if(temp == 6 || temp== 9 && set[6] != set[9]) {
				if(set[6] < set[9]) set[6] +=1;
				
				else set[9] +=1;
			}
			else {
				set[temp] +=1;
			}
		}
		int max = 0;
		for(int i = 0; i < set.length; i++) {
			max = Math.max(max, set[i]);
		}
		System.out.println(max);
	}
}
/*
 배열 0으로 초기화 하고 해당 하는 값 인덱스 +=1 
 6 or 9 가 들어오고 두 인덱스 값이 다르면 작은곳에 +=1
 배열 순회 하면서 최대값 출력
 */
