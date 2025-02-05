import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int [] num, ret;
	
	static Set<String> set = new LinkedHashSet<String>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
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
			 StringBuilder sb = new StringBuilder();
			for(int temp : ret) {
				sb.append(temp+ " ");
			}
			set.add(sb.toString().trim());
			return;
		}
		for(int i = start; i < n; i++) {
			ret[cnt] = num[i];
			combi(cnt +1, i +1);
		}
	}
}