import java.util.*;
import java.io.*;

class Solution {
    static boolean [][] visited;
    static int [] di = {0,0,1,-1};
    static int [] dj = {1,-1,0,0};
    static int n,m;
    
    static class Pos{
        int row, col, cnt;
            Pos(int row, int col, int cnt){
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }
    
    public int solution(int[][] maps) throws IOException{
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        int answer = bfs(0,0, maps);
        return answer;
    }
    
    static int bfs(int nowi, int nowj, int[][] maps){
        Queue<Pos> q = new LinkedList<>();
        visited[nowi][nowj] = true;
        q.offer(new Pos(nowi, nowj, 1));
        
        while(!q.isEmpty()){
            Pos temp = q.poll();
            
            for(int d = 0; d < 4; d++){
                int newi = di[d] + temp.row;
                int newj = dj[d] + temp.col;
                
                if(newi == n -1 && newj == m - 1){
                    return temp.cnt + 1;
                }
                
                if(newi >= 0 && newi < n && newj >= 0 && newj < m && !visited[newi][newj] && maps[newi][newj] == 1){
                    visited[newi][newj] = true;
                    q.offer(new Pos(newi, newj, temp.cnt + 1));
                }
            }
        }
        return -1;
    }
}