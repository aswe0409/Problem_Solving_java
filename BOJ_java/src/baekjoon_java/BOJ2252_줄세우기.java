package baekjoon_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2252_줄세우기 {
	static int[] cha;
	static List<Integer>[] list;
	static int n;
	static int m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 학생 수
		m = sc.nextInt(); // 비교 수
		
		cha = new int[n+1]; //진입차수 배열
		list = new ArrayList[n+1];
		
		for(int i = 0; i <n+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			cha[b]++;
		}
		bfs();
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i < n+1; i++) { // 1번 인덱스 부터
			if(cha[i] == 0) { // 진입 차수가 0 이면 큐에 넣기
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			System.out.println(temp +" ");
			for(int idx: list[temp]) {
				cha[idx] -=1;
				
				if(cha[idx] == 0) {
					q.add(idx);
				}
			}
		}
		return;
	}
	
}
