import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Tower{
		int idx, height;
		
		Tower(int idx, int height){
			this.idx = idx;
			this.height = height;
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            while (!s.isEmpty() && s.peek().height < temp) {
                s.pop();
            }
            if (s.isEmpty()) {
                sb.append('0').append(' ');
            }
            else{
                sb.append(s.peek().idx).append(" ");
            }
            s.push(new Tower(i,temp));
        }
        System.out.println(sb.toString());
    }
}