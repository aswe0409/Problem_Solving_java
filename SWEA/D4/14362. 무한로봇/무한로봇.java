import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static class Robot{
		int x = 0;
		int y = 0;
		int dir = 0; // 0우 1하 2좌 3상
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int [] dx = {1,0,-1,0};
		int [] dy = {0,1,0,-1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test =1; test<= t; test++) {
			String order = br.readLine();
			int ans = 0;
			
			Robot r = new Robot();
			for(int d = 0; d <4; d++) { //4번 돌고 나면 원점으로 돌아옴
				for(int i = 0; i < order.length(); i++) {
					char temp = order.charAt(i);
					if(temp == 'S') {
						r.x += dx[r.dir];
						r.y += dy[r.dir];
						int dis = (int)(Math.pow(r.x, 2)+ Math.pow(r.y,2));
						ans = Math.max(ans, dis);
					}
					else if(temp == 'L') {
						r.dir +=1;
						if(r.dir == 4) {
							r.dir = 0;
						}
					}
					else if(temp == 'R') {
						r.dir -= 1;
						if(r.dir == -1) {
							r.dir = 3;
						}
					}
				}
			}
			if(r.x == 0 && r.y == 0) {
				System.out.println("#"+test+" "+ans);
			}
			else {
				System.out.println("#"+test+" "+ "oo");
			}
		}
	}
}