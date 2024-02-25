package prac;

import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrixTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		//무향 그래프 일때
		int [][] adjMatrix = new int[V][V]; //0으로 초기화 (인접 되지 않은 상태로 초기화)
		for(int i = 0; i < E; i++) { //간선 수 만큼 돌아야 함
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		
		for(int [] row: adjMatrix) {
			System.out.println(Arrays.toString(row));
		}
	}
}


/*
7  //정점 수
8  // 간선 수 
0 1
0 2
0 5
0 6
4 3
5 3
5 4
6 4
 
  */
