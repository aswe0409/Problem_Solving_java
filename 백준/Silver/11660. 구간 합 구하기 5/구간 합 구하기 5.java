import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[n][n];
        int[][] memo = new int[n][n];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 0; i < n; i++) {
        	memo[i][0] = map[i][0];
        	for(int j = 1; j < n; j++) {
        		memo[i][j] = map[i][j] + memo[i][j-1];
        	}
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int startx = Integer.parseInt(st.nextToken())-1;
        	int starty = Integer.parseInt(st.nextToken())-1;
        	int endx = Integer.parseInt(st.nextToken())-1;
        	int endy = Integer.parseInt(st.nextToken())-1;
        	
        	int ret = 0;
        	
        	for(int x = startx; x <= endx; x++) {
        		if(starty - 1 < 0) {
        			ret += memo[x][endy];
        		}
        		else {
            		ret += memo[x][endy] - memo[x][starty-1];
        		}
        	}
        	System.out.println(ret);
        }
    }
}