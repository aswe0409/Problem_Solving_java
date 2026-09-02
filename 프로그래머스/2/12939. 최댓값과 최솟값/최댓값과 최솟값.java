import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s, " ");

        int count = st.countTokens();
        int[] arr = new int[count];
        

        for(int i = 0; i < count; i++){
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
        }
        
        Arrays.sort(arr);
        
        answer = arr[0] + " "+ arr[count-1];
        return answer;
    }
}