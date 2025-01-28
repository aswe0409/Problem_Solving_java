import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static int [] num,s;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());

			k = Integer.parseInt(st.nextToken());
			
			if(k == 0) {
				break;
			}
			num = new int[k];
			s = new int [6];
			for(int i = 0; i < k; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			combi(0,0);
			System.out.println();
		}
	}
	static void combi(int cnt, int start) {
		if(cnt == 6) {
			for(int temp : s) {
				System.out.print(temp+" ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i < k; i++) {
			s[cnt] = num[i];
			combi(cnt + 1, i + 1);
		}
	}
}