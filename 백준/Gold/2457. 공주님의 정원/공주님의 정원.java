import java.io.*;
import java.util.*;

public class Main {
	static class Flowers implements Comparable<Flowers>{
		int start, end;
		Flowers(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Flowers o) {
			//시작일 순으로 오름차순
			if(this.start != o.start) {
				return this.start - o.start;
			}
			//시작일이 같으면 끝나는 날 순으로 내림차순 정렬 
			return o.end - this.end;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Flowers[] f = new Flowers[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			
			int start = startMonth * 100 + startDay;
			int end = endMonth * 100 + endDay;
			
			f[i] = new Flowers(start, end);
		}
		Arrays.sort(f);
		
		int sDay = 301;
		int eDay = 1201;
		int cnt = 0;
		int idx = 0;
		int max = 0;
		while(sDay < eDay) {
			boolean isFind = false;
			
			for(int i = idx; i < n; i++) {
				//종료일 보다 시작일 이후면 의미 없음
				if(f[i].start > sDay) {
					break;
				}
				if(max < f[i].end) {
					isFind = true;
					max = f[i].end;
					idx = i + 1;
				}
			}
			if(isFind) {
				sDay = max;
				cnt += 1;
			}
			else {
				break;
			}

		}
		if(max < eDay) {
			System.out.println(0);
		}
		else {
			System.out.println(cnt);
		}
	}
}