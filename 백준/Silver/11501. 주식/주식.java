//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        
//    }
//}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int test = 0; test < T; test++) {
        	int n = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int[] arr = new int[n];
        	
        	for(int i = 0; i < n; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	int maxNum = 0;
        	long sum = 0;
        	for(int i = n - 1; i >= 0; i--) {
        		if(maxNum > arr[i]) {
        			sum += maxNum - arr[i];
        		}
        		else {
        			maxNum = arr[i];
        		}
        	}
        	System.out.println(sum);
        }
    }
}