import java.io.*;
import java.util.*;

public class Main {
	static int [] arr;
	static int n, ret = 0;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		combi(0);
		System.out.println(ret);
	}
	static void combi(int cnt) {
		if(cnt == n) {
			ret++;
			return;
		}
		for(int i = 0; i < n; i++) {
			arr[cnt] = i; //인덱스를 행, 값을 열로 이용
			if(check(cnt)) {
				combi(cnt +1);
			}
		}
	}
	static boolean check (int cnt) {
		//가로 세로 탐색
		for(int i = 0; i < cnt; i++) {
			if(arr[i] == arr[cnt]) {
				return false;
			}
			// 대각선 탐색(열 의 차 - 행의 차 == 대각선에 위치임
			else if(Math.abs(cnt - i) == Math.abs(arr[cnt] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}