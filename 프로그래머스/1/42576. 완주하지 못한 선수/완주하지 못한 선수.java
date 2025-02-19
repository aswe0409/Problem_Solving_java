import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 참가자 기준으로 hashmap 만들기
        
        HashMap <String, Integer> map = new HashMap<>();
        
        for(String temp : participant){
            map.put(temp, map.getOrDefault(temp, 0) + 1);    
        }
        
        for(String temp : completion){
            map.put(temp, map.getOrDefault(temp, 0) - 1);
        }
        
        for(String key : map.keySet()){
            int value = map.get(key);
            if(value == 1){
                answer = key;
            }
        }
        
        return answer;
    }
}