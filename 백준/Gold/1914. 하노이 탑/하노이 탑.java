import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger ret = (new BigInteger("2")).pow(n).subtract(new BigInteger("1"));
		System.out.println(ret);
		
		if(n <= 20) {
			hanoi(n,1,2,3);
			System.out.println(sb);
		}
	}
	static void hanoi(int num, int start, int mid, int to) {
		if(num ==1) {
			sb.append(start+" "+to+"\n");
			return;
		}
		hanoi(num-1, start,to, mid);
		sb.append(start+" "+to+"\n");
		hanoi(num-1, mid, start, to);
	}
}