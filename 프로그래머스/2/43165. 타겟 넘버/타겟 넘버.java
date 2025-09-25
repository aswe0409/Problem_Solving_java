import java.io.*;
import java.util.*;

class Solution {
    static int ret, n;
    public int solution(int[] numbers, int target) throws IOException {
        n = numbers.length;
        ret = 0;
        ref(0, numbers, target, 0);
        return ret;
    }
    
    static void ref(int num, int[] numbers, int target, int cnt){
        if(cnt == n){
            if(num == target){
                ret += 1;
            } 
            return;
        }
        
        ref(num + numbers[cnt], numbers, target, cnt + 1);
        ref(num - numbers[cnt], numbers, target, cnt + 1);
        
    }
}