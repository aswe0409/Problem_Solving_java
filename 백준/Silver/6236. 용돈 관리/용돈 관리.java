import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int [] num;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		
		int low = 0;
		int high = 0;
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			low = Math.max(low, num[i]);
			high += num[i];
		}

		int ret = 0;
		while(low <= high) {
			int mid = (low + high) / 2;
			boolean state = useMoney(mid);
			if(state) {
				ret = mid;
				high = mid - 1;
			}
			//m이 더 작은경우
			else if(!state) {
				low = mid + 1;
			}
		}
		System.out.println(ret);
	}
	
	static boolean useMoney(int money) {
		int balance = money;
		int cnt = 1;
		
		for(int i = 0; i < N; i++) {
			//잔액 부족하면 인출
			if(balance < num[i]) {
				balance = money;
				cnt+=1;
			}
			balance -= num[i]; // 사용
		}
		
		if(cnt <= M) {
			return true;
		}
		else {
			return false;
		}
	}
}