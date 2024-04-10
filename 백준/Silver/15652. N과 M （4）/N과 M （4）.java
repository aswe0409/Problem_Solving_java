import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int [] num; //숫자 후보 담을 배열
	static boolean []visit; 
	static int [] ans; // 결과 담았다 뺏다가 할 배열
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];
		visit = new boolean[n];
		ans = new int[m];
		
		for(int i = 1; i <=n; i++) {
			num[i-1] = i;
		}
		
		func(0,0);
		System.out.println(sb.toString());
	}
	static void func(int cnt, int start) {
		if(cnt == m) {
			for(int temp : ans) {
				sb.append(temp).append(" ");
			}
			sb.append("\n");
			return;
		}
		else {
			for(int i = start; i < n; i++) {
					ans[cnt] = num[i];
					func(cnt+1, i);
			}
		}
	}
}