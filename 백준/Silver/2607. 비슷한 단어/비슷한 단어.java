import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String str = br.readLine();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < str.length(); i++) {
        	map1.put(str.charAt(i), map1.getOrDefault(str.charAt(i),0)+ 1);
        } 
        
        int cnt = 0;
        
        for(int i = 0; i < N-1;i++) {
        	String temp = br.readLine();
        	
        	// 두 단어 같은 경우
        	if(str.equals(temp)) {
        		cnt += 1;
        	}
        	// 다른 경우
        	else {
        		//길이 차가 2 이상이면 바꿀수가 없음
        		if(Math.abs(temp.length() - str.length()) > 1) {
        			continue;
        		}
        		
        		else {
        			//각 자리수 비교해서 차이 1이하면 ok
        			for (int j = 0; j < temp.length(); j++) {
        		        map.put(temp.charAt(j), map.getOrDefault(temp.charAt(j), 0) + 1);
        		    }
        			int diff = 0;
        			
        			for (char c = 'A'; c <= 'Z'; c++) {
        		        diff += Math.abs(map1.getOrDefault(c, 0) - map.getOrDefault(c, 0));
        		    }

        		    if (diff <= 2) {
        		    	cnt += 1;
        		    }
        			map.clear();
        		}
        	}
        }
        System.out.println(cnt);
    }
}