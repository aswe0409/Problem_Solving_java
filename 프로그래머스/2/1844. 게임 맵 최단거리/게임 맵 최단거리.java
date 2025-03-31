import java.util.*;

class Solution {
    static class Pos{
    int row, col, cnt;
    Pos(int row, int col, int cnt){
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}
    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};
    static boolean [][] visited;
    static Queue<Pos> q;
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        q = new LinkedList<>();
        
        answer = bfs(0,0, maps);
        return answer;
    }
    static int bfs(int nowi, int nowj, int[][] map){
        int n = map.length;    
        int m = map[0].length;
        
        q.offer(new Pos(nowi, nowj, 1));
        visited[nowi][nowj] = true;
        
        while(!q.isEmpty()){
            Pos temp = q.poll();
            
            for(int d = 0; d < 4; d++){
                int newi = temp.row + di[d];
                int newj = temp.col + dj[d];
                
                if(newi == n - 1  && newj ==  m - 1){
                    return temp.cnt+1;
                }
                
                if(newi >= 0 && newi < n && newj >= 0 && newj < m && !visited[newi][newj] && map[newi][newj] == 1){
                    q.offer(new Pos(newi, newj, temp.cnt + 1));
                    visited[newi][newj] = true;
                }
            }
        }
        return -1;
    }
}