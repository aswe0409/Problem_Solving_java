import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int [] sumNums = new int[n];
        
        st = new StringTokenizer(br.readLine());
        sumNums[0] = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i < n; i++) {     	
        	sumNums[i] = Integer.parseInt(st.nextToken()) + sumNums[i-1];
        	
        }
        
        for(int t = 0; t < m; t++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken()) -1;
        	int end = Integer.parseInt(st.nextToken()) - 1;
        	
        	if(start - 1 > -1) {
        		System.out.println(sumNums[end]- sumNums[start-1]);
        	}
        	else {
        		System.out.println(sumNums[end]);
        	}
        	
        }
        
    }
}