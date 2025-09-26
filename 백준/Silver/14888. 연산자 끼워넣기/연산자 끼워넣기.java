import java.io.*;
import java.util.*;

public class Main {
	static int[] oper, nums;
	static int n;
    static int maxRet = Integer.MIN_VALUE;
    static int minRet = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        oper = new int[4]; //연산자 넣을 곳
        
        for(int i = 0; i < n; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer temp = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
        	oper[i] = Integer.parseInt(temp.nextToken());
        }
        
        func(nums[0], 1);
        System.out.println(maxRet);
        System.out.println(minRet);
    }
    
    static void func(int num, int cnt) {
    	if(cnt == n) {
    		maxRet = Math.max(num, maxRet);
    		minRet = Math.min(num, minRet);
    		return;
    	}
    	
    	for(int i = 0; i < 4; i++) {
    		if(oper[i] > 0) {
        		oper[i] -= 1; //해당 연산자 사용
    			switch(i) {
    			case 0: func(num + nums[cnt], cnt +1); break; 
    			case 1: func(num - nums[cnt], cnt +1); break; 
    			case 2: func(num * nums[cnt], cnt +1); break; 
    			case 3: func(num / nums[cnt], cnt +1); break; 
    			}
    			oper[i] += 1;
    		}
    	}
    }
}