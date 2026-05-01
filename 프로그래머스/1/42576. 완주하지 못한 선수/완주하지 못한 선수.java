import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String temp : participant){
            map.put(temp, map.getOrDefault(temp, 0) +1);
        }
        
        for(String temp : completion){
            map.put(temp, map.getOrDefault(temp, 0)  -1);
        }
        
        for(String temp: map.keySet()){
            if(map.get(temp) == 1){
                answer = temp;
            }
        }
        return answer;
    }
}