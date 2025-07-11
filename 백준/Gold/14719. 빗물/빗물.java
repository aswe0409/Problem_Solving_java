/*
 * 맵 전체 탐색하면서 1일 때 해당 좌표 기준으로 오른쪽 탐색 하다가 1만나면 벽 만난거니까 물 더해주고
 * 못 만난거면 그냥 없애
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] map = new int[h][w];

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < w; i++) {
            int height = Integer.parseInt(st.nextToken());
            for (int j = h - 1; j >= h - height; j--) {
                map[j][i] = 1;
            }
        }

        int cnt = 0;

        for (int i = 0; i < h; i++) { 
            int j = 0;
            while (j < w) {
            	//벽 만나면 0 탐색 
                if (map[i][j] == 1) {
                    int temp = 0;
                    j++;
                    while (j < w && map[i][j] == 0) {
                        temp++;
                        j++;
                    }
                 // 양쪽 벽 있을 때만 cnt에 진짜 더해주기
                    if (j < w && map[i][j] == 1) {
                        cnt += temp;  
                    }
                } 
                
                else {
                    j++;
                }
            }
        }
        System.out.println(cnt);
    }
}