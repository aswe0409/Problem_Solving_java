import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int []num;
	static int [] ret;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num = new int[n];
		ret = new int[m];
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(str.nextToken());
		}
		
		Arrays.sort(num);
		func(0,0);
		System.out.println(sb.toString());
	}
	
	private static void func(int cnt, int start) {
		if(cnt == m) {
			for(int temp : ret) {
				sb.append(temp+" ");
			}
			sb.append('\n');
			return;
		}
		else {
			for(int i = start; i < n; i++) {
				ret[cnt] = num[i];
				func(cnt +1, i +1);
			}
		}
	}
}