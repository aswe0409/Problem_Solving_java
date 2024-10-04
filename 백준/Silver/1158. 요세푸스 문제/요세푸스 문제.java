import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque<>();
		List<Integer> ret = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			dq.add(i);
		}
		
		while(dq.size()!=0) {
			for(int i = 0; i < K-1; i++) {
				int temp = dq.removeFirst();
				dq.add(temp);
			}
			ret.add(dq.removeFirst());
		}
		System.out.print("<"+ret.get(0));
		for(int i = 1; i < N; i++) {
			System.out.print(", "+ret.get(i));
		}
		System.out.print(">");
	}
}
