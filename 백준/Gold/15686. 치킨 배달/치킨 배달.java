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
	static int ans = 0;
	static int n,m,min;
	static List<Pos> home = new ArrayList<>();
	static List<Pos> chicken = new ArrayList<>();
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int temp = Integer.parseInt(str.nextToken());
				if(temp == 1) { // 집 일 경우
					home.add(new Pos(i,j));
				}
				else if(temp == 2) { //치킨집일 경우
					chicken.add(new Pos(i,j));
				}
			}
		} 
		
		min = Integer.MAX_VALUE;
		visit = new boolean[chicken.size()];
		func(0,0);
		System.out.println(min);
	}
	static void func(int cnt, int start) {
		if(cnt ==m) { // m개 골랐으면 각 지집에서 치킨집 거리 구하고 가장 가까운거 distiace 변수에 담아줌
			calDistance();
		}
		
		for(int i = start; i < chicken.size(); i++) { //조합으로 치킨집 m개 고르고
			visit[i] = true; 
			func(cnt+1, i+1);
			visit[i] = false; //썼으면 반납
		}
	}
	static void calDistance() {
		int distance = 0;
		for(int i = 0; i < home.size(); i++) {
			int temp_min = Integer.MAX_VALUE;
			for(int j  = 0; j <chicken.size(); j++) {
				if(visit[j]) {
					int temp_distance = Math.abs(home.get(i).row - chicken.get(j).row) + Math.abs(home.get(i).col - chicken.get(j).col);
					temp_min = Math.min(temp_min, temp_distance);
				}
			}
			distance += temp_min;
		}
		min = Math.min (min, distance);
		return;
	}
}