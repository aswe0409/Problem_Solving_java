import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int time = 0;
		int [] num = new int[n];
		for(int i = 0; i < n; i++) {
			time += arr[i];
			num[i] = time;
		}
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			cnt += num[i];
		}
		System.out.println(cnt);
	}
}