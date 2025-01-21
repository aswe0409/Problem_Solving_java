import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		System.out.println(pow(A,B,C));
	}
	static long pow(long a, long b, long c) {
		if(b == 1) {
			return a % c;
		}
		else {
			long half = pow(a, b /2, c);
			if(b % 2 == 1) {
				return (half * half % c) * a % c;
			}
			return half * half % c;
		}
	}
}