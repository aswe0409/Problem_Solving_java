import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Pos{
		int row, col;
		Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	
	static int n,m, min;
	static int [][] arr;
	static List<Pos> home = new ArrayList<>();
	static List<Pos> kfc = new ArrayList<>();
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken()); // 최대 치킨 집 수
			arr = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					int temp = Integer.parseInt(str.nextToken());
					if(temp == 1) { // 집 일 경우
						home.add(new Pos(i,j));
					}
					else if(temp == 2) { //치킨집일 경우
						kfc.add(new Pos(i,j));
					}
				}
			} // i for
			
			min = Integer.MAX_VALUE;
			visit = new boolean[kfc.size()];
			func(0,0);
			System.out.println(min);
		}
	}
	
	private static void func(int cnt, int start) {
		if(cnt == m) {
			int dist = 0;
			
			for(int i = 0; i < home.size(); i++) {
				int temp_min = Integer.MAX_VALUE;
				for(int j = 0; j < kfc.size(); j++) {
					if(visit[j]) {
						int temp_dist = Math.abs(home.get(i).row -kfc.get(j).row);
						temp_dist +=  Math.abs(home.get(i).col -kfc.get(j).col);
						temp_min = Math.min(temp_min, temp_dist);
					}
				}
				dist += temp_min;
			}
			
			min = Math.min(min, dist);
			return;
		}
		
		for(int i = start; i < kfc.size(); i++) {
			visit[i] = true;
			func(cnt+1,i+1);
			visit[i] = false;
		}
	}
}