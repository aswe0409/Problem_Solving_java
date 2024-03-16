package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14891_톱니바퀴 {
	static class Pos{
		int rs, rw;
		Pos(int rs, int rw){
			this.rs = rs; // 1이면 회전 0이면 회전 x
			this.rw = rw; // 1이면 시계, -1이면 반 시계
		}
	}
	static int ret = 0;
	static int [][]arr; //톱니 담을 배열
	static Pos [] state; //회전 여부 담을 배열 1이면 회전 0이면 놉
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[4][8];
		for(int i = 0; i < 4; i++) {
			String line = br.readLine();
			for(int j = 0; j < line.length(); j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < k; i++) {
		    state = new Pos[4];
		    for(int j = 0; j < state.length; j++) {
		        state[j] = new Pos(0, 0); // state 배열의 각 요소를 Pos 객체로 초기화
		    }
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int num = Integer.parseInt(st.nextToken());
		    int way = Integer.parseInt(st.nextToken());

		    state[num-1].rs = 1; // 해당 톱니바퀴의 회전 여부를 1로 설정
		    state[num-1].rw = way; // 회전 방향 설정
		    rotateState(num-1, way);
		    rotate();
		    
		}
		count();
		System.out.println(ret);
	}
	static void rotateState(int idx, int way) {
	    int left = idx - 1;
	    int right = idx + 1;
	    int leftway = way;
	    int rightway = way;
	    
	    //왼쪽 톱니 회전 검사
	    while (left >= 0) {
	        if (arr[left][2] != arr[left + 1][6]) {
	            leftway *= -1;
	            state[left].rs = 1;
	            state[left].rw = leftway; 
	        } else {
	            break;
	        }
	        left--;
	    }
	    
	    //오른쪽 톱니 회전 감사
	    while (right < arr.length) {
	        if (arr[right - 1][2] != arr[right][6]) {
	            rightway *= -1;
	            state[right].rs = 1;
	            state[right].rw = rightway;  
	        } else {
	            break;
	        }
	        right++;
	    }
	} //rotateState
	
	static void rotate() {
		for(int i = 0; i < 4; i++) {
			if(state[i].rs == 1) {// 회전
				if(state[i].rw == 1) { //시계방향 회전
					int temp = arr[i][7];
	                for(int j = 7; j > 0; j--) {
	                    arr[i][j] = arr[i][j-1];
	                }
	                arr[i][0] = temp;
				}
				else { // 반 시계방향 회전
					 int temp = arr[i][0];
					 for(int j = 0; j < 7; j++) {
		                    arr[i][j] = arr[i][j+1];
		                }
		                arr[i][7] = temp;
				}
			}
		}
	}
	
	static void count() {
		int snum = 1;
		for(int i = 0; i < 4; i++) {
			if(arr[i][0] == 1) {
				ret += snum;
			}
			snum*=2;
		}
		
	}
	
	
}
