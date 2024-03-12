package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 3개 뽑는게 고정이라
정렬해서 want 로 뽑힌 값 보다 작은 개수 * 큰 개수 하면 답 나옴 
인덱스를 ~보다 작은 값의 개수다 라고 생각 해서 품
*/

public class softeer_자동차테스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(arr);
        
        for(int i = 0; i < q; i++) {
            int want = Integer.parseInt(br.readLine());
            int idx = binarySearch(arr, want);
            if(idx != -1) {
                int left = idx;
                int right = n - idx - 1;
                System.out.println(left * right);
            }
            else {
                System.out.println(0);
            }
        }
    }
    
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // 못 찾음
    }
}
