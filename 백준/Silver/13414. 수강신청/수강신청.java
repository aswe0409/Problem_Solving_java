import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		LinkedHashSet<String> set = new LinkedHashSet<>();
		
		for(int i = 0; i < l; i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				set.remove(str);
			}
			set.add(str);
		}
		
		int cnt = 0;
		for(String temp : set) {
			if(cnt == k) {
				break;
			}
			sb.append(temp+"\n");
			cnt++;
		}
		System.out.println(sb);
	}
}