import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> minus = new ArrayList<>();
		List<Integer> plus = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp <= 0) {
				minus.add(temp);
			}
			else {
				plus.add(temp);
			}
		}
		Collections.sort(minus);
		Collections.sort(plus, Collections.reverseOrder());
		
		long ret = 0;
		
		for(int i = 0; i < plus.size(); i+=2) {
			if(i +1 >= plus.size()) {
				break;
			}
			//두 수가 같을 때 곱하면 손해임 => 더해
			else if(plus.get(i) == 1 && plus.get(i+1)== 1) {
				ret += plus.get(i) + plus.get(i+1);
				plus.set(i,0);
				plus.set(i+1,0);
			}
			// 곱해 => 근데 둘중에 하나라도 1일 때 곱하면 손해
			else if(plus.get(i) != 1 && plus.get(i+1) != 1){
				ret += plus.get(i) * plus.get(i+1);
				plus.set(i,0);
				plus.set(i+1,0);
			}
		}
		
		for(int i = 0; i < minus.size(); i+=2) {
			if(i +1 >= minus.size()) {
				break;
			}
			
			ret += minus.get(i) * minus.get(i+1);
			minus.set(i,0);
			minus.set(i+1,0);
		}
		for(int i = 0; i < minus.size(); i++) {
			ret += minus.get(i);
		}
		for(int i = 0; i < plus.size(); i++) {
			ret += plus.get(i);
		}
		System.out.println(ret);
	}
}