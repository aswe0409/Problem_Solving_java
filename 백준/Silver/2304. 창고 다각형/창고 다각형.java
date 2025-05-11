//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        
//    }
//}

import java.io.*;
import java.util.*;

public class Main {
    static class Square implements Comparable<Square>{
    	int x, y;
    	Square(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    	
    	@Override
    	public int compareTo(Square o1) {
    		return this.x - o1.x;
    	}
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Square [] arr = new Square[n];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i] = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        Arrays.sort(arr);
        
        int maxHeight = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].y > maxHeight) {
                maxHeight = arr[i].y;
                maxIdx = i;
            }
        }

        int area = 0;
        
        // 가장 높은거 기준으로 왼쪽 탐색
        int height = arr[0].y;
        int leftX = arr[0].x;
        for (int i = 1; i <= maxIdx; i++) {
            if (arr[i].y > height) {
                area += (arr[i].x - leftX) * height;
                height = arr[i].y;
            } else {
                area += (arr[i].x - leftX) * height;
            }
            leftX = arr[i].x;
        }


        // 가장 높은거 기준으로 오른쪽 탐색
        height = arr[n - 1].y;
        int rightX = arr[n - 1].x;
        for (int i = n - 2; i >= maxIdx; i--) {
            if (arr[i].y > height) {
                area += (rightX - arr[i].x) * height;
                height = arr[i].y;
            } else {
                area += (rightX - arr[i].x) * height;
            }
            rightX = arr[i].x;
        }

        // 가장 높은 기둥 구간 더해주기
        area += maxHeight;

        System.out.println(area);       
    }
}