import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        long m = Long.parseLong(br.readLine());
        Arrays.sort(arr);
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        
        if (sum <= m) {
            System.out.println(arr[n-1]);
        } else {
            long low = 0;
            long high = arr[n-1];
            long answer = 0;
            
            while (low <= high) {
                long mid = (low + high) / 2;
                long tempSum = 0;
                
                for (int i = 0; i < n; i++) {
                    if (arr[i] < mid) {
                        tempSum += arr[i];
                    } else {
                        tempSum += mid;
                    }
                }
                
                if (tempSum <= m) {
                    answer = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            System.out.println(answer);
        }
    }
}
