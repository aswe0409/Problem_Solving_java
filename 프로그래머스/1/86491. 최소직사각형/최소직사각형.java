import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) throws IOException{
        //가로는 가장 긴변 주고 긴변끼리 비교
        // 세로는 짧은 변주고 짧은 변 끼리 비교 max 값 바꿔
        int maxW = 0;
        int maxH = 0;
        
        for(int i = 0; i < sizes.length; i++){
            int tempw = Math.max(sizes[i][0], sizes[i][1]);
            int temph = Math.min(sizes[i][0], sizes[i][1]);
            maxW = Math.max(maxW, tempw);
            maxH = Math.max(maxH, temph);
        }
        return maxW * maxH;
    }
}