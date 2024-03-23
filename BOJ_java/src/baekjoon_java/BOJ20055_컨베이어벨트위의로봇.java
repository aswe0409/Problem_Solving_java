package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20055_컨베이어벨트위의로봇 {
	static class state{
		int exist,  dur;
		state(int exist, int dur){
			this.exist = exist;
			this.dur  = dur;
		}
	}
	static state [] arr;
	static int ret = 0; // 몇번 회전 했는지 담을 결과 값
	static int n, k;  // n = 배열 크기 , k = 내구도 0인 칸 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 배열 크기
		k = Integer.parseInt(st.nextToken()); // 내구도 0인 칸 개수
		
		arr = new state[2*n];
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 2*n; i++) {
			arr[i] = new state(0,Integer.parseInt(str.nextToken()));
		}
		rotate();
	}
	
	static void rotate() {//벨트 회전 
		state temp = arr[2*n-1];
		for(int i = 2*n-1; i > 0; i--) {
			if(i == n) {//n 에서 내리기
				arr[i].exist = 0; 
			}
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
	}
	
	static void move() {
		
	}
}
