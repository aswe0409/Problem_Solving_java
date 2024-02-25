package baekjoon_java;

import java.util.Arrays;
import java.util.Scanner;

public class ex3273 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //수열 크기
		int arr[] = new int[n];
		int front = 0;
		int rear = n -1;
		int cnt =0;
		
		for(int i =0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int x = sc.nextInt(); // 맞춰야 하는 숫자
		
		//arr sort
		Arrays.sort(arr);
		
		while(front != rear && rear > front) { //rear > front 이 조건 안 넣어 주면 엇 갈릴 수 있음
			if(arr[front] + arr[rear] == x) {
				cnt +=1;
				front +=1;
				rear -=1;
			}
			else if(arr[front] + arr[rear] > x) {
				rear-=1;
			}
			
			else if(arr[front] + arr[rear] < x) {
				front +=1;
			}
		}
		System.out.println(cnt);
	}
}
