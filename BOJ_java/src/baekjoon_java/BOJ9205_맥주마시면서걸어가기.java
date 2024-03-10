package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9205_맥주마시면서걸어가기 {
	static class Pos{
		int row, col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	static int n, starti, startj, endi, endj;
	static List<Pos> arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int test = 0; test < tc; test++) {
			n = Integer.parseInt(br.readLine()); // 편의점 개수
			StringTokenizer st = new StringTokenizer(br.readLine());
			starti = Integer.parseInt(st.nextToken());
			startj = Integer.parseInt(st.nextToken());
			arr = new LinkedList<>();
			boolean state = false;
			
			for(int i = 0; i < n; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				arr.add(new Pos(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken())));
			}
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			endi = Integer.parseInt(st1.nextToken());
			endj = Integer.parseInt(st1.nextToken());
			
			//시작점에서 바로 갈수잇는지 확인
			if(Math.abs(starti - endi) + Math.abs(startj - endj) <= 1000) {
				System.out.println("happy");
				continue;
			}
			// 바로 못 가면 bfs 
			else {
				state = bfs();
			}
			
			if(state == true) {
				System.out.println("happy");
			}	
			else {
				System.out.println("sad");
			}
		}
	}
	
    private static boolean bfs() {
        Queue<Pos> q = new LinkedList<>();
        boolean[] visit = new boolean[n];
        q.add(new Pos(starti, startj)); // 시작 위치에서 BFS 시작 해야 됨 왜냐면 집에서 출발해서 편의점을 들려야지 편의점에서 출발하는게 아니엿슴

        while (!q.isEmpty()) {
            Pos temp = q.poll();
            if (Math.abs(temp.row - endi) + Math.abs(temp.col - endj) <= 1000) {
                return true;
            }

            for (int i = 0; i < n; i++) {
                if (!visit[i] && Math.abs(temp.row - arr.get(i).row) + Math.abs(temp.col - arr.get(i).col) <= 1000) {
                    visit[i] = true;
                    q.add(new Pos(arr.get(i).row, arr.get(i).col));
                }
            }
        }
        return false;
    }
}
