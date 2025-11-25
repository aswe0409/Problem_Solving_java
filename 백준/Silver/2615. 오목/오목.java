import java.util.*;
import java.io.*;

public class Main {
    static int[] di = {0, 1, 1, -1};
    static int[] dj = {1, 0, 1, 1};
	static int [][] map;
	static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = 19;
        map = new int[n][n];
        
        boolean isTrue = false;
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < 19; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(map[i][j] == 1) {
        			//검정 돌 탐색
        			if(check(i,j,1)) {
        				System.out.println(1);
        				System.out.println((i+1) + " "+ (j+1));
        				isTrue = true;
        			}
        		}
        		else if(map[i][j] == 2) {
        			// 흰돌 탐색
        			if(check(i,j,2)) {
        				System.out.println(2);
        				System.out.println((i+1) + " "+ (j+1));
        				isTrue = true;
        			}
        		}
        	}
        }
        if(!isTrue) {
            System.out.println(0);
        }
    }
    
    static boolean check(int nowi, int nowj, int target) {
    	//8방 탐색
    	for(int d = 0; d < 4; d++) {
    		int cnt = 1;
    		
        	int newi = nowi + di[d];
        	int newj = nowj + dj[d];
        	while (newi >= 0 && newi < n && newj >= 0 && newj < n && map[newi][newj] == target) {
                cnt++;
                newi += di[d];
                newj += dj[d];
            }
        	// 뒤에도 체크해서 해당 돌이 처음 시작 돌 인지 확인
        	int bi = nowi - di[d];
            int bj = nowj - dj[d];
            while (bi >= 0 && bi < n && bj >= 0 && bj < n && map[bi][bj] == target) {
                cnt++;
                bi -= di[d];
                bj -= dj[d];
            }
            
            if(cnt == 5) {
            	// 처음 시작 돌 인지 체크
            	int prev_i = nowi - di[d];
                int prev_j = nowj - dj[d];
                if (prev_i >= 0 && prev_i < n && prev_j >= 0 && prev_j < n
                        && map[prev_i][prev_j] == target) {
                    continue; 
                }
                return true;
            }
    	}
    	return false;
   	}
}