import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int [] num, ret;
	static boolean [] visit;
	static StringBuilder sb;
	static LinkedHashSet<String> ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];
		ret = new int[m];
		visit = new boolean[n];
		ans = new LinkedHashSet<String>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
//		for(int i = 0; i < n; i++) {
//			System.out.println(num[i]);
//		}
		func(0, 0);
		
		for(String temp : ans) {
			System.out.println(temp);
		}
	}
	static void func(int cnt, int start) {
		if(cnt == m) {
			sb = new StringBuilder();
			for(int temp : ret ) {
				sb.append(temp).append(" ");
			}
			//sb.append("\n");
			ans.add(sb.toString());
			return;
		}
		else {
			for(int i = start; i < n; i++) {
					ret[cnt] = num[i];
					func(cnt+1, i);
			}
		}
	}
}