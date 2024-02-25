package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int S = Integer.parseInt(st.nextToken()); // 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 비밀번호 길이
        
        char[] arr = br.readLine().toCharArray();
        
        String[] secondLine = br.readLine().split(" "); // A, C, G, T의 최소 개수
        int A = Integer.parseInt(secondLine[0]);
        int C = Integer.parseInt(secondLine[1]);
        int G = Integer.parseInt(secondLine[2]);
        int T = Integer.parseInt(secondLine[3]);
        
        int[] cnt = new int[4]; // A, C, G, T의 개수를 저장할 배열
        int sum = 0;
        
        // 초기 윈도우 설정
        for (int i = 0; i < P && i < S; i++) {
            increaseCount(cnt, arr[i]);
        }
        
        if (check(cnt, A, C, G, T)) {
            sum++;
        }
        
        // 슬라이딩 윈도우 이동
        for (int i = P; i < S; i++) {
            increaseCount(cnt, arr[i]); // 새로운 문자 추가
            decreaseCount(cnt, arr[i - P]); // 윈도우 맨 앞의 문자 제거
            
            if (check(cnt, A, C, G, T)) {
                sum++;
            }
        }
        
        System.out.println(sum);
    }
    
    private static void increaseCount(int[] cnt, char c) {
        switch (c) {
            case 'A': cnt[0]++; break;
            case 'C': cnt[1]++; break;
            case 'G': cnt[2]++; break;
            case 'T': cnt[3]++; break;
        }
    }
    
    private static void decreaseCount(int[] cnt, char c) {
        switch (c) {
            case 'A': cnt[0]--; break;
            case 'C': cnt[1]--; break;
            case 'G': cnt[2]--; break;
            case 'T': cnt[3]--; break;
        }
    }
    
    private static boolean check(int[] cnt, int A, int C, int G, int T) {
        return cnt[0] >= A && cnt[1] >= C && cnt[2] >= G && cnt[3] >= T;
    }
}
