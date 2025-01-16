import java.util.*;
import java.io.*;

public class Main {
	static int num;
	static int [] arr;
	static boolean [] visited, done;
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 0; test < T; test++) {
			num = Integer.parseInt(br.readLine());
			arr = new int[num+1];
			visited = new boolean[num+1]; // 방문 여ㅜ
			done = new boolean[num+1]; // 팀 결성 여부
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= num; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 1; i <= num; i++) {
				if(!done[i]) { // 팀결성 안된애들만 탐색하면 돼
					dfs(i);
				}
			}
			System.out.println(num - cnt);
		}
	}
	
	static void dfs(int now) {
		int next = arr[now];
		
		// 지금 내가 방문 했던거면 순환 완성
		if(visited[now]) {
			done[now] = true;
			cnt += 1;
		}
		
		// 아니면 방문 처리
		else {
			visited[now] = true;
		}
		// 팀 완성이 안 되어 있으면 팀 구하러가
		if(!done[next]) {
			dfs(next);
		}
		
		visited[now] = false;
		done[now] = true; // 나 자신도 팀 완성 된거 처리
	}
}