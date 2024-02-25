package baekjoon_java;

import java.util.Scanner;

public class ex12927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int cnt = 0;

        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'Y') {
            	cnt +=1;
                for (int j = i; j < arr.length; j += (i + 1)) {
                    if (arr[j] == 'Y') {
                    	arr[j] = 'N';
                    } else {
                    	arr[j] = 'Y';
                    }
                }
            }
        }
            boolean state = true;
            for (char c : arr) {
                if (c == 'Y') {
                	state = false;
                    break;
                }
            }

            if (state) {
                System.out.println(cnt);
                return;
            }
            else {
            	System.out.println(-1);
        }
    }
}