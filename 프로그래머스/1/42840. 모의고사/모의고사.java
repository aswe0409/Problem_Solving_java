import java.io.*;
import java.util.*;

class Solution {
    public List solution(int[] answers) throws IOException{
        int[] A = {1,2,3,4,5};
        int[] B = {2,1,2,3,2,4,2,5};
        int[] C = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == A[i%5]) score[0] += 1;
            if(answers[i] == B[i%8]) score[1] += 1;
            if(answers[i] == C[i%10]) score[2] += 1;
        }
        
        int maxScore = Math.max(score[0], score[1]);
        maxScore = Math.max(maxScore, score[2]);
        
        List<Integer> ret = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            if(maxScore == score[i]){
                ret.add(i+1);
            }
        }
        return ret;
    }
}