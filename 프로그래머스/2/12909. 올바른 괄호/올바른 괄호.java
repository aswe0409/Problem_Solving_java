import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<>();
        
        for(int i= 0; i < s.length(); i++){
            if(st.isEmpty()){
                if(s.charAt(i) == ')'){
                    return false;
                }
            
                else{
                    st.push(s.charAt(i));
                }
            }
            else{
                if(st.peek() == s.charAt(i)){
                    st.push(s.charAt(i));
                }
                else{
                    st.pop();
                }
            }
        }
        if(!st.isEmpty()){
            return false;
        }

        return answer;
    }
}