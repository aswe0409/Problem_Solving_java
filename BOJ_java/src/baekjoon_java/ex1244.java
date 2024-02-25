package baekjoon_java;

import java.util.Scanner;

public class ex1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int student = sc.nextInt();
		
		for(int i = 0; i < student; i++) {
			int sex = sc.nextInt();
			int swic = sc.nextInt();
			
			if(sex == 1) { //남자일 경우
				for(int j = swic-1; j < n; j+=swic) {
					if(arr[j] == 1) arr[j] = 0;
					else arr[j] = 1;	
				}
			}
			else { //여자일 경우
				swic -=1;
				if(arr[swic] == 1) arr[swic] = 0;
				else arr[swic] = 1;
				int cnt = 1;
				
				while(true) {
					if(swic - cnt < 0 || swic + cnt >= n) {
						break;
					}
					else {
						if(arr[swic - cnt] == 1 && arr[swic + cnt] == 1) {
							arr[swic - cnt] = 0;
							arr[swic + cnt] = 0;
							cnt++;
						}
						else if(arr[swic-cnt] == 0 && arr[swic + cnt] == 0) {
							arr[swic - cnt] = 1;
							arr[swic + cnt] = 1;
							cnt++;
						}
						else {
							break;
						}
					}
				}
			}

		}
        for (int k = 0; k < n; k++) {
            System.out.print(arr[k] + " ");
            if ((k + 1) % 20 == 0) {
                System.out.println();
            }
        }
	}
}
