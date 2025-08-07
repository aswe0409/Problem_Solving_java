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
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> s = new Stack<>();
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	while (!s.isEmpty() && s.peek() > y) {
	            s.pop();
	            cnt++;
	        }
        	
	        if (s.isEmpty() || s.peek() < y) {
	            if (y > 0) s.push(y);
	        }
        }
        
    	cnt += s.size();
        System.out.println(cnt);
    }
}