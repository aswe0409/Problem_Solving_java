import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long ret = 0;
        Stack<Long> s = new Stack<>();
        for(int i = 0; i < n; i++){
            long temp = Long.parseLong(br.readLine());
            if(!s.isEmpty() && s.peek() <= temp){
                while(!s.isEmpty() && s.peek() <= temp) {
                    s.pop();
                }
            }
            ret = ret + s.size();
            s.push(temp);
        }
        System.out.println(ret);
    }
}