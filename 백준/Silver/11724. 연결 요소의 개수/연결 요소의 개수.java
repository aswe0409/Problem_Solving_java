import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n,m;
	static ArrayList<Integer> [] arr;
	static boolean [] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new ArrayList[n+1];
		
		visit = new boolean[n+1];
		
		for(int i  = 0; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}
		
//		for(int i = 0; i <= n; i++) {
//			int size = arr[i].size();
//			for(int j = 0; j < size; j++) {
//				System.out.println(arr[i].get(j));
//			}
//			System.out.println();
//		}
		
		int cnt = 0;
		
		for(int i = 1; i <= n; i++) {
			if(!visit[i]) {
				cnt +=1;
				bfs(i);
			}
		}	
		System.out.println(cnt);
	}
	static void bfs(int now) {
		Queue<Integer> q = new LinkedList<Integer>();
		visit[now] = true;
		q.offer(now);
		while(!q.isEmpty()) {
			int idx = q.poll();	
			int size = arr[idx].size();
			
			for(int i = 0; i < size; i++) {
				int temp = arr[idx].get(i);

				if(!visit[temp]) {
					q.offer(temp);
					visit[temp] = true;
				}
			}
		}
		return;
	}
}