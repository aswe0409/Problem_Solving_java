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
        int t = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[100001][4];
        
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        
        for(int i = 4; i < 10001; i++) {
        	dp[i][1] = dp[i-1][1];
        	dp[i][2] = dp[i-2][1] + dp[i-2][2];
        	dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }
        

        for(int test = 0; test < t; test++) {
        	int n = Integer.parseInt(br.readLine());
        	System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }
    }
}

