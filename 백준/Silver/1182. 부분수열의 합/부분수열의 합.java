import java.io.*;
import java.util.*;

public class Main {
	static int n,s, count;
	static int [] num, ret;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		count = 0;
		
		num = new int [n];
		ret = new int [n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		combi(0,0);
		System.out.println(count);
	}
	static void combi(int cnt, int start) {
		if(cnt > 0) {
			int sum = 0;
			for(int temp : ret) {
				sum += temp;
			}
			if(s == sum) {
				count += 1;
			}
		}
		
		for(int i = start; i < n; i++) {
			ret[cnt] = num[i];
			combi(cnt + 1, i+1);
			ret[cnt] = 0;
		}
	}
}