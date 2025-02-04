import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static char [] num, ret;
	static int mo = 0, ja = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		num = new char[C]; //후보 단어들 저장
		ret = new char[L]; //결과 단어들 저장
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			num[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(num);
		
		combi(0,0);
	}
	static void combi(int cnt, int start) {
		if(cnt == L) {
			if(mo >= 1 && ja >= 2) {
				for(char temp : ret) {
					System.out.print(temp);
				}
				System.out.println();
			}
			return;
		}
		
		for(int i = start; i < C; i++) {
			ret[cnt] = num[i];
			if(num[i] == 'a' || num[i] == 'e' || num[i] == 'i' || num[i] == 'o' || num[i] == 'u') {
				mo += 1;
			}
			else {
				ja += 1;
			}
			combi(cnt + 1, i + 1);
			if(num[i] == 'a' || num[i] == 'e' || num[i] == 'i' || num[i] == 'o' || num[i] == 'u') {
				mo -= 1;
			}
			else {
				ja -= 1;
			}
		}
	}
}