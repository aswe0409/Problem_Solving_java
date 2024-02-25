package baekjoon_java;

import java.util.Scanner;

public class ex2991 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b, c, d ,p, m, n= 0;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		p = sc.nextInt();
		m = sc.nextInt();
		n = sc.nextInt();
		
		int pcnt =0;
		int mcnt = 0;
		int ncnt = 0;
		
		if( a >= (a+b)%p) pcnt++;
		if( a >= (a+b)%m) mcnt++;
		if( a >= (a+b)%n) ncnt++;
		
		if( c >= (c+d)%p) pcnt++;
		if( c >= (c+d)%m) mcnt++;
		if( c >= (c+d)%n) ncnt++;
		
		
		System.out.println(pcnt+" "+ mcnt+ " " +ncnt );
		
		
	}
}
