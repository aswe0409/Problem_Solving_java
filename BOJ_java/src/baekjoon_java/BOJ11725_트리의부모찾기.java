package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11725_트리의부모찾기 {
	static int n;
	static Queue<Integer> q;
	static ArrayList<ArrayList<Integer>> arr; // 노드 입력 받을 리스트
	static boolean visit[]; // 방문처리 할 배열
	static int ret []; //결과 담을 배열
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new ArrayList<ArrayList<Integer>> ();
		ret = new int[n+1];
		
		for(int i = 0; i <=n; i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		bfs();
		
		for(int i = 2; i <=n; i++) {
			System.out.println(ret[i]);
		}
	}
	
	private static void bfs() {
		q = new LinkedList<Integer>();
		visit = new boolean[n+1];
		q.offer(1);
		visit[1] = true;
		
		while(!q.isEmpty()) {
			int parent = q.poll(); // 이 값을 부모로 쓸거임
			//1이랑 연결 되어있는 애들 빼 주면서 얘네 부모 1로 
			for(int temp:arr.get(parent)) {
				if(!visit[temp]) {
					ret[temp] = parent;
					visit[temp] = true;
					q.offer(temp);
				}
			}
		}
	}
}
