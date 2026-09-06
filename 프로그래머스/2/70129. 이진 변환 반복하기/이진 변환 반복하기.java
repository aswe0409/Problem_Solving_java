import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int cnt = 0;
        int remove = 0;
        
        while(s.length() != 1){
            cnt += 1;
            int tempLength = s.length();
            
            //1. 0 제거
            s = s.replace("0","");
            remove += (tempLength - s.length());
            
            // 2. 길이 2진법으로 
            s = convert(s.length());
            
        }
        answer = new int[]{cnt, remove};
        return answer;
    }
    static private String convert(int leng){
        String temp = "";
        while(leng > 0){
            if(leng % 2 == 1){
                temp += "1";
            }
            else{
                temp += "0";
            }
            leng /=2 ;
        }
        
        return temp;
    }
}