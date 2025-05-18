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
        
        String str = br.readLine();
        int ret = Integer.MAX_VALUE;
        
        
        //R  맨 앞으로 모으기 맨 앞에 안 모여 있는 R 개수 세기
        int cnt = 0;
        boolean flag = false;
        for(int i = 0; i < n; i++) {
        	if(flag && str.charAt(i) == 'R') {
        		cnt +=1;
        	}
        	else if(str.charAt(i) == 'B') {
        		flag = true;
        	}
        }
        
        ret = Math.min(ret, cnt);
        
        //B 맨 앞으로 맨 앞에 안 모여 있는 B개수 세기
        cnt = 0;
        flag = false;       
        for(int i = 0; i < n; i++) {
        	if(flag && str.charAt(i) == 'B') {
        		cnt +=1;
        	}
        	else if(str.charAt(i) == 'R') {
        		flag = true;
        	}
        }
        ret = Math.min(ret, cnt);
        
        
        //R 맨 뒤로
        cnt = 0;
        flag = false;       
        for(int i = n-1; i >= 0; i--) {
        	if(flag && str.charAt(i) == 'R') {
        		cnt +=1;
        	}
        	else if(str.charAt(i) == 'B') {
        		flag = true;
        	}
        }
        
        ret = Math.min(ret, cnt);
       
        // B 맨 뒤로
        cnt = 0;
        flag = false;       
        for(int i = n-1; i >= 0; i--) {
        	if(flag && str.charAt(i) == 'B') {
        		cnt +=1;
        	}
        	else if(str.charAt(i) == 'R') {
        		flag = true;
        	}
        }
        
        ret = Math.min(ret, cnt);
        
        System.out.println(ret);
    }
}