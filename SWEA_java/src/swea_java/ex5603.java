package swea_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex5603 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int sum = 0;
			int ret = 0;
			
			List<Integer> arr = new ArrayList<Integer>();
			for(int i = 0; i < n; i++) {
				arr.add(sc.nextInt());
				sum += arr.get(i);
			}
			int avg = sum / arr.size();
			for(int i = 0; i <n; i++) {
				if(arr.get(i) > avg) {
					ret = ret + arr.get(i) - avg;
				}
			}
			
			System.out.println("#"+tc+" "+ret);
			
		}
	}
	
	//10m35s
}
