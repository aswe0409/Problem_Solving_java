import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int n;
	static int [] number;
	static int [] oper = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//n = Integer.parseInt(br.readLine());
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		number = new int[n];
		
		
		for(int i = 0; i < n; i++) {
			number[i] = sc.nextInt();
		}
		
		//st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 4; i++) {
			oper[i] = sc.nextInt();
		}
		
		func(number[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void func(int num, int idx) {
		if(idx == n) {
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}
		
		for(int i = 0; i <4; i++) {
			if(oper[i] > 0) {
				oper[i]--; // 해당 연산자 사용 햇으니까 -1
				switch(i) {
				case 0: func(num + number[idx], idx+1); break;
				case 1: func(num - number[idx], idx+1); break;
				case 2: func(num * number[idx], idx+1); break;
				case 3: func(num / number[idx], idx+1); break;
				}
				oper[i]++; //사용 후 다시 반납
			}
		}
	}
}