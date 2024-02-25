package baekjoon_java;

import java.util.Scanner;

public class ex1914 {
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		if(num <=20) {
			counthanoi(num, 1, 3, 2);
			System.out.println(cnt);
			hanoi(num,1,3,2);
		}
		else {
			counthanoi(num, 1, 3, 2);
			System.out.println(cnt);
			highHanoi(num,1,3,2);
		}
	}
	
	static void printHanoi(int startPoint, int endPoint) {
		cnt+=1;

		System.out.println(startPoint+ " "+ endPoint);
	}
	
	static void hanoi(int num, int startPoint, int endPoint, int midPoint) {
		if(num ==1) {// end condition 마지막 애를 최종 목적지로
			printHanoi(startPoint, endPoint);
			//System.out.println(cnt);
			return;
		}
		
		else {
			hanoi(num-1, startPoint, endPoint, midPoint);
			printHanoi(startPoint, midPoint);
			hanoi(num-1, midPoint, endPoint, startPoint);
			
		}
	}
	
	static void highHanoi(int num, int startPoint, int endPoint, int midPoint) {
		if(num ==1) {// end condition 마지막 애를 최종 목적지로
			cnt+=1;
			return;
		}
		else {
			hanoi(num-1, startPoint, midPoint, endPoint);
			hanoi(num-1, midPoint, endPoint, startPoint);
		}
	
	}
	
	static void counthanoi(int num, int startPoint, int endPoint, int midPoint) {
		if(num ==1) {// end condition 마지막 애를 최종 목적지로
			cnt+=1;
			return;
		}
		
		else {
			cnt+=1;
			counthanoi(num-1, startPoint, midPoint, endPoint);
			counthanoi(num-1, midPoint, endPoint, startPoint);
		}
	}
}
