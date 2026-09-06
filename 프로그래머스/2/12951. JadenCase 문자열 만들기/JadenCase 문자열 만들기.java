import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        boolean state = true; // f = 첫글자, t 는 다른글자
        
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                answer += ' ';
                state = true;
            }
            else{
                if(!state){
                    answer+= Character.toLowerCase(s.charAt(i));
                }
                else{
                    answer+= Character.toUpperCase(s.charAt(i));
                    state = false;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}