import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long ans;
	static int arr[];
	static int state;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		ans = 0;
		
		for (int i = 0; i < n; i++) {
			state =0;
			int target = arr[i];
			
			
			if(i == 0&& state ==0) { // 맨 앞에 숫자는 뒤에 있는 숫자만 체크
				rearCheck(target,i+1,n-1,i);
			}
			else if(i == n-1  && state == 0) { //맨 뒤 숫자는 앞에만 체크 하면 됨
				frontCheck(target,0,i-1,i);
			}
			else {
				if(state == 0) {
					frontCheck(target,0,i-1,i);
				}
				if (state == 0) {
					rearCheck(target,i+1,n-1,i);
				}
				if (state == 0) {
					centerCheck(target , 0, n-1, i);
				}
				
			}
		}
		System.out.println(ans);
	}
	
	static void frontCheck(int target, int front, int rear,int now) {
		while(front != rear) {
			int temp =arr[front] + arr[rear]; 
			if(temp == target) {
//				System.out.println("now" + now);
//				System.out.println("target= "+target);
//				System.out.println(arr[front]+" "+ arr[rear]);
				ans +=1;
				state = 1;
				break;
			}
			
			if(temp > target) {
				rear -=1;
			}
			else {
				front+=1;
			}
		}
	}
	
	static void rearCheck(int target, int front, int rear, int now) {
		while(front != rear) {
			int temp =arr[front] + arr[rear]; 
			if(temp == target) {
//				System.out.println("now" + now);
//				System.out.println("target= "+target);
//				System.out.println(arr[front]+" "+ arr[rear]);
				ans +=1;
				state =1;
				
				break;
			}
			
			if(temp > target) {
				rear -=1;
			}
			else {
				front+=1;
			}
		}
	}
	
	static void centerCheck(int target, int front, int rear, int now) {
//		System.out.println(now+"@@@@@@@");
		while(front != now && rear != now) {
			int temp =arr[front] + arr[rear]; 
			if(temp == target) {
//				System.out.println("now" + now);
//				System.out.println("target= "+target);
//				System.out.println(arr[front]+" "+ arr[rear]);
				ans +=1;
				state =1;
				break;
			}
			
			if(temp > target) {
				rear -=1;
			}
			else {
				front+=1;
			}
		}
	}
}