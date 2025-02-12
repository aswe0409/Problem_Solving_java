import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int [] num, ret;
	static HashSet<String> set = new LinkedHashSet<String>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];
		ret = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		combi(0,0);
		for(String s : set) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
	static void combi(int cnt, int start) {
		if(cnt == m) {
			StringBuilder sb1 = new StringBuilder();
			for(int temp : ret) {
				sb1.append(temp + " ");
			}
			set.add(sb1.toString().trim());
			return;
		}
		for(int i = 0; i < n; i++) {
			ret[cnt] = num[i];
			combi(cnt + 1, i);
		}
	}
}