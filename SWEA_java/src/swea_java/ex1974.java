package swea_java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ex1974 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int tc = 1; tc <= t; tc++) {
			int state = 0;
			int[][] arr = new int[9][9];
			
			//input arr
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// row check

			for(int i = 0; i < 9; i++) {
				Set<Integer> rset = new HashSet<Integer>();
				for(int j = 0; j < 9; j++) {
					rset.add(arr[i][j]);
				}
				if(rset.size()!=9) {
					state = 1;
					break;
				}
			}
			
			// col check
			for(int i = 0; i < 9; i++) {
				Set<Integer> cset = new HashSet<Integer>();
				for(int j = 0; j < 9; j++) {
					cset.add(arr[j][i]);
				}
				if(cset.size()!=9) {
					state = 1;
					break;
				}
			}
			
			// square check

			for(int i = 0; i < 7; i+=3) {
				for(int j = 0; j < 7 ; j+=3) {
					Set<Integer> sset= new HashSet<Integer>();
					for(int k = i; k < i+3; k++) {
						for(int z = j; z< j+3; z++) {
							sset.add(arr[k][z]);
						}
					}
					if(sset.size() != 9) {
						state = 1;
						break;
					}
				}

				
			}
			if(state == 0) System.out.println("#" + tc+ " " + 1);
			else System.out.println("#" + tc+ " " + 0);
		}
	}
}
