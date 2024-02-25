package baekjoon_java;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ex1021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> dq = new LinkedList<Integer>();
		
		int N =	sc.nextInt(); // q 크기
		int M = sc.nextInt(); // 뽑는 숫자 개수
		int arr[] = new int[M];
		
		for(int i = 1; i <= N; i++) {
			dq.offer(i);
		}
		
		for(int i = 0; i < M; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt = 0; // 연산 횟수
		
		for(int i = 0; i < M; i++) {
			int idx = 0;
			Iterator<Integer> itr = dq.iterator();
	        while (itr.hasNext()) {
	            if (itr.next() == arr[i]) {
	            	break;
	            }
	            idx+=1;
	        }

            if (idx <=  dq.size()/ 2) { // 타겟이 앞쪽에 더 가까운 경우
                while (arr[i] != dq.peekFirst()) {
                    dq.offerLast(dq.pollFirst()); // 앞의 요소를 뒤로 이동
                    cnt++;
                }
            } else { // 타겟이 뒤쪽에 더 가까운 경우
                while (arr[i] != dq.peekFirst()) {
                    dq.offerFirst(dq.pollLast()); // 뒤의 요소를 앞으로 이동
                    cnt++;
                }
            }
            dq.pollFirst();
        }
        
        System.out.println(cnt);
    }
}
