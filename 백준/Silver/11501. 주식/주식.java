import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test = 0; test < t; test++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int [] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long maxNum = 0;
			long ret = 0;
			for(int i = n -1; i >= 0; i--) {
				int temp = arr[i];
				if(temp > maxNum) {
					maxNum = temp;
				}
				else if(temp < maxNum) {
					ret = ret + maxNum - temp;
				}
			}
			System.out.println(ret);
		}
	}
}