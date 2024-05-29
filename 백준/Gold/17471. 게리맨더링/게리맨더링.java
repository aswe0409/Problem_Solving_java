import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int [] people;
	static boolean [] visit;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> a;
	static ArrayList<Integer> b;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        people = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
        	list[i] = new ArrayList<>();
        }
        for(int i = 1; i <= n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int num = Integer.parseInt(st.nextToken());
        	for(int j = 0; j < num; j++) {
        		list[i].add(Integer.parseInt(st.nextToken()));
        	}
        }
        visit = new boolean[n+1];
        subset(0);
        if(ans == Integer.MAX_VALUE) {
        	System.out.println(-1);
        }
        else {
        	System.out.println(ans);
        }
	}
	static void subset(int cnt) {
		if(cnt == n) {
			 a = new ArrayList<Integer>();
			 b = new ArrayList<Integer>();
			 for(int i = 1; i <= n; i++) {
				 if(visit[i]) {
					 a.add(i);
				 }
				 else {
					 b.add(i);
				 }
			 }
			 if(a.isEmpty()||b.isEmpty()) {
				 return;
			 }
			 
			 if(bfs(a) && bfs(b)) {
				 int sum1 = 0;
				 int sum2 = 0;
				 for(int i = 1; i <=n ; i++) {
					 if(visit[i]) {
						 sum1 +=people[i];
					 }
					 else {
						 sum2 += people[i];
					 }
				 }
				 ans = Math.min(ans, Math.abs(sum1-sum2));
			 }
			 return;
		}
		visit[cnt] = true;
		subset(cnt+1);
		visit[cnt] = false;
		subset(cnt+1);
	}
	static boolean bfs(ArrayList<Integer> a) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean [] visit = new boolean[n+1];
		q.add(a.get(0));
		visit[a.get(0)] = true;
		int cnt =1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int temp:list[cur]) {
				if(a.contains(temp) && !visit[temp]) {
					visit[temp] = true;
					q.add(temp);
					cnt +=1;
				}
			}
		}
		return cnt == a.size();
	}
}