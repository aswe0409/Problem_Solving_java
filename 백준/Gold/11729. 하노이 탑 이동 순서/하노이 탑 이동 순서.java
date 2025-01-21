import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//System.out.println(Math.round(Math.pow(2,n)-1));
		sb.append((int)(Math.pow(2,n)-1)).append("\n");
		hanoi(n,1,2,3);
		System.out.println(sb);
	}
	
	static void hanoi(int num, int start, int mid, int to) {
		//종료 조건
		if(num == 1) {
			sb.append(start+" "+ to+ "\n");
			return;
		}
		hanoi(num -1, start, to, mid);
		sb.append(start+" "+ to+ "\n");
		hanoi(num -1, mid, start, to);
	}
}