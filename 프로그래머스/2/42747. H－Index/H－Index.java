import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) throws IOException {
        int n = citations.length;
        Arrays.sort(citations);
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            int h = n - i;
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}