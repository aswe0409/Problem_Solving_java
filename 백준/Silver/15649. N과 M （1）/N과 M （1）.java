import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int num[]; // 
	static int ret[]; // 결과 담을 배열
	static boolean  visited[]; // 방문 여부
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];
		for(int i = 0; i < n; i++) {
			num[i] = i+1;
		}
		ret = new int[m];
		visited = new boolean[n];
		comb(0);
		System.out.println(sb.toString());
	}
	
	private static void comb(int cnt) {
		if(cnt == m) {
			for(int temp : ret) {
				sb.append(temp+" ");
			}
			sb.append('\n');
			return;
		}
		else {
			for(int i = 0; i < n; i++) {
				if(!visited[i]) {
					ret[cnt] = num[i];
					visited[i] = true;
					comb(cnt+1);
					visited[i] = false;
				}
			}
		}
	}
}