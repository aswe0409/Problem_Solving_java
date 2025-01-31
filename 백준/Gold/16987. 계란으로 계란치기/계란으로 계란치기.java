import java.io.*;
import java.util.*;

public class Main {
	static class Egg{
		int s, w;
		public Egg(int s, int w) {
			this.s = s; //내구도
			this.w = w; // 무게
		}
	}
	static int n;
	static Egg[]  arr;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new Egg[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Egg(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		perm(0);
		System.out.println(count);
	}
	static void perm(int idx) {
		if(idx == n) {
			int tempCnt = 0;
			for(Egg temp : arr) {
				if(temp.s <= 0) {
					tempCnt += 1;
				}
			}
			count = Math.max(tempCnt, count);
			return;
		}
		
		if(arr[idx].s <= 0 ) { //혀ㅑㄴ재 계란이 이미 깨진경우 다음 계란 이동
			perm(idx +1);
			return;
		}
		boolean isHit = false;
		for(int i = 0; i < n; i++) {
			if(i == idx || arr[i].s <= 0) {
				continue;
			}
				arr[idx].s -= arr[i].w;
				arr[i].s -= arr[idx].w; 
				isHit = true;
				perm(idx + 1);
				arr[idx].s += arr[i].w;
				arr[i].s += arr[idx].w; 
		}
		if(!isHit) perm(idx +1);
	}
}