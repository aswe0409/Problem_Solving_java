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
        StringBuilder sb = new StringBuilder();
        
        for(int test = 0; test < t; test++) {
        	int minLength = 10002;
        	int maxLength = 0;
        	String str = br.readLine();
        	char [] letters = str.toCharArray();

        	int[] alpa = new int[26];
        	int k = Integer.parseInt(br.readLine());
        	
        	if (k == 1) {
                //System.out.println("1 1");
        		sb.append(1+ " "+ 1);
        		sb.append("\n");
                continue;
            }
        	
        	// 알파벳 인덱스에 맞게 파싱
        	for(int i = 0; i < str.length(); i++) {
        		alpa[letters[i] - 'a'] += 1;
        	}
        	
        	
        	for(int i = 0; i < str.length(); i++) {
        		char start = str.charAt(i);
        		int cnt = 1;
        		if(alpa[start-'a'] < k) { // 알파벳 개수가 k 보다 작게 있으면 탐색 할 필요 없음
        			continue;
        		}
            	
        		for(int j = i + 1; j < str.length(); j++) {
        			//start 다음 문자무터 탐색
        			if(start == str.charAt(j)) {
        				cnt += 1;
        			}

        			if(cnt == k) {
        				minLength = Math.min(minLength, j - i+ 1);
        				maxLength = Math.max(maxLength, j - i + 1);
        				break;
        			}
        		}
        	}
        	if(minLength == 10002 || maxLength == 0) {
        		sb.append(-1);
        		//System.out.println(-1);
        	}
        	else {
        		sb.append(minLength+ " "+ maxLength);
        		//System.out.println(minLength+ " "+ maxLength);
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
}
