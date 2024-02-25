package prac;

import java.util.Arrays;
import java.util.Scanner;

public class AdjListTest {
	static class Node{
		int to;
		Node next;
		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
		public Node(int to) {
			this.to = to;
		}
		@Override
		public String toString() {
			return "Node [to=" + to + ", next=" + next + "]";
		}
		 
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		//무향 그래프 일때 : 연결리스트 버전
		Node [] adjList = new Node[V]; // 각 정점의 인저빌스트의 헤드 저장
		for(int i = 0; i < E; i++) { //간선 수 만큼 돌아야 함
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]); // 맨 앞으로 삽입 알고리즘
			adjList[to] = new Node(from, adjList[to]); 
			
		}
		
		for(Node node: adjList) {
			System.out.println(node);
		}
	}
}


/*
7  //정점 수
8  // 간선 수 
7
8
0 1
0 2
0 5
0 6
4 3
5 3
5 4
6 4
 
  */
