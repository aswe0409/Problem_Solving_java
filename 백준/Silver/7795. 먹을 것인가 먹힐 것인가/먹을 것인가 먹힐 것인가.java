import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int test = 0; test < n; test++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			Integer [] arrA = new Integer[A];
			Integer [] arrB = new Integer[B];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < A; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < B; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arrA, Collections.reverseOrder());
			Arrays.sort(arrB, Collections.reverseOrder());
			
			int idxA = 0;
			int idxB = 0;
			int cnt = 0;
			
			while(true) {
				if(idxB < B && arrA[idxA] <= arrB[idxB]) {
					idxB++;
				}
				else {
					cnt += B - idxB;
					idxA++;
				}
				if(idxA == A) {
					break;
				}
			}
			System.out.println(cnt);
		}
	}
}