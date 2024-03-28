import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int [][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[9][9];
		
		for(int i = 0; i < 9; i++) {
			String line = br.readLine();
			for(int j =0; j < 9; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		dfs(0);
	}
	
	//num이라는 칸 번호를 부여 받았고 거기가 빈칸일 경우 1~9의 숫자를 채우는 역할
	// 마지막 81번을 제회하고는 판을 채웠다라고 확인할 수 없음
	// 만약 1~9 숫자를 다 놓고 기다렸는데 81번인 애한테 성공이라는 알림을 못 받으면 난 실패
	// 내 선배 재귀가 숫자르 ㄹ바꿔서 나를 다시 부르기를 기다려야 함
	static boolean dfs(int num) {
		if(num == 81) {// 0 ~ 80번 칸이 모두 숫자로 채워지고 나 불렀으면 완성
			for(int i = 0; i < 9; i++) {
				for(int j =0; j < 9; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			return true;
		}
		
		int i = num/9; //칸 번호가 2차 배열 행. 열 좌표 어디인지 계산햇 ㅓ체크 하기
		int j = num % 9;
		
		boolean result = false; // 나는 성공 여부 모름. 내가 부른 다음애가 true 가져와야 확인 됨.
		
		if(board[i][j] != 0) { // 기존에 숫자 있던 칸은 그냥 다음 칸으로 ㄴ머기면 됨
			result = dfs(num +1);
		}
		else { //빈칸이면 숫자를 채워봐야 함
			for(int n = 1; n <= 9; n++) {
				//n이 써도 되는지 체크하고 안되는 n은 제껴야 함.
				if(!check(i,j,n)) continue;
				
				board[i][j] = n; //일단 내칸 채워밨는데.. 다른 숫자로 바꿔야 될수도 있으닉 기다리자
				result = dfs(num+1);
				if(result) break; // 오 기다렸더니 true가 왔어!! 숫자 그만 놓자
				board[i][j] = 0; //방금 놨던 숫자 안됐나보다. for문 끝날 수도 있으니 0을 ㅗ돌려놓기
				
			}
		}
		return result;
	}
	static boolean check(int nowi, int nowj, int n) {
		for(int i = 0; i <9; i++) {// 맨 위부터 맨 아래로 쭉 내려가면서 체크
			if(board[i][nowj] == n)
				return false;
		}
		
		for(int j = 0; j < 9; j++) {
			if(board[nowi][j] == n) return false;
		}
		
		int si = nowi/3*3;
		int sj = nowj/3*3;
		
		for(int i = si; i <si+3; i++) {
			for(int j = sj; j < sj+3; j++) {
				if(board[i][j] == n) return false;
			}
		}
		return true;
	}
}