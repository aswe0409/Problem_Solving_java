package baekjoon_java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ex1269 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int anum = sc.nextInt(); // a 집합 원소 개수
		int bnum = sc.nextInt(); // b 집합 원소 개수
		
		Set<Integer> a = new HashSet<Integer>();
		Set<Integer> b = new HashSet<Integer>();
		Set<Integer> temp = new HashSet<Integer>();
		
		for(int i = 0; i < anum; i++) {
			a.add(sc.nextInt());
		}
		
		for(int i = 0; i < bnum; i++) {
			b.add(sc.nextInt());
		}
		temp.addAll(a);
		a.removeAll(b);
		b.removeAll(temp);
		
		System.out.println(a.size()+b.size());
	}
}
