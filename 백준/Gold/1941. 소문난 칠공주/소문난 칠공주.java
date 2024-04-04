import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pos{
		int row, col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	static char[][] arr;
	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };
	static boolean select[];
	static int ret = 0; // 결과 담을 배열
	static char [] seven;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr = new char[5][5];
		select = new boolean[25];
		seven = new char[7];
		
		for(int i = 0; i < 5; i++) {
			String temp = sc.nextLine();
			for(int j = 0; j < 5; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		
		func(0,0); // 조합
		System.out.println(ret);
	}
	
	private static void func(int cnt, int start) {
		if(cnt == 7) {

			// 7명중 4명이 S 인가 확인
			int scnt = 0;
			for(int i = 0; i < 7; i++) {
				if(seven[i] == 'S') {
					scnt+=1;
				}
			}
			
			if(scnt<4) { // 3명 이하면 return
				return;
			}
			 
			// 7명이 인접한지 check bfs 활용
			boolean state = false; // 7명이 인접하면 true
			for(int i = 0; i < 25; i++) {
				if(select[i]) {
					state = bfs(i);
				}
			}
			
            for (int i = 0; i < 25; i++) {
                if (select[i]) {
                    if (bfs(i)) {
                        ret++;
                        break;
                    }
                }
            }

			return;
		} // if cnt = 7
		
		for(int i = start; i < 25; i++) {
			select[i] = true;
			seven[cnt] = arr[i/5][i%5];
			func(cnt + 1, i +1);
			select[i] = false;
	
		}
	}
	
	private static boolean bfs(int start) {
		Queue<Pos> q = new LinkedList<>();
		int nowi = start / 5;
		int nowj = start % 5;
		q.offer(new Pos(nowi, nowj));
		int cnt = 1;
		boolean[][] visited = new boolean[5][5];
		visited[nowi][nowj]= true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			
			for(int k = 0; k < 4; k++) {
				int newi = temp.row + di[k];
				int newj = temp.col + dj[k];
				
				if(newi >= 0 && newi < 5 && newj >= 0 && newj < 5 && select[newi *5 + newj] && !visited[newi][newj]) {
					q.offer(new Pos(newi, newj));
					visited[newi][newj] = true;
					cnt+=1;
				}
			}
		}
		if(cnt == 7) {
			return true;
		}
		else {
			return false;
		}
	}
}