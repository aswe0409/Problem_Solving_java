import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] order;
	static int [][] arr;
	static boolean[] visit;
	static int max = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        order = new int[9];
        arr = new int[n][9];
        visit = new boolean[9];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit[0] = true;
        order[3] = 0; // 4번 타자는 1번째 선수

        perm(0);
        System.out.println(max);
	}
	
	private static void perm(int cnt) {
		if(cnt == 9) {
			play();
			return;
		}
		
		if(cnt == 3) {
			perm(cnt+1);
		}
		else {
			for(int i = 0; i < 9; i++) {
				if(!visit[i]) {
					order[cnt] = i;
					visit[i] = true;
					perm(cnt+1);
					visit[i] = false;
				}
			}
		}
	}
	
	private static void play() {
		int score = 0; // 점수 담을 변수
		int start = 0; // 처음 시작 하는 타자
		
		for(int i = 0; i < n; i++) {//n 이닝동안 play
			int base[] = new int[4]; // 1번 인덱스 부터 사용할 거임
			int out = 0; //아웃 카운트
			while(out < 3) {
				int hitter = order[start % 9];  //  해당 타자의 결과 값
				int hit = arr[i][hitter];
				
				switch(hit) {
				case 0: // 아웃
					out +=1;
					break;
					
				case 1: //1루타
					score += base[3];
					base[3] = base[2];
					base[2] = base[1];
					base[1] = 1;
					break;
				
				case 2: // 2루타
					score = score + base[3] + base[2];
					base[3] = base[1];
					base[2] = 1;
					base[1] = 0;
					break;
					
				case 3: //3루타
					score = score + base[1] + base[2] + base[3];
					base[3] =1;
					base[2] = base[1] = 0;
					break;
					
				case 4: //홈런
					score = score + base[1] + base[2] + base[3] +1;
					base[2] = base[1] = base[3]= 0;
					break;
				}
				start++;
			}
		}
		max = Math.max(max, score);
	}
}