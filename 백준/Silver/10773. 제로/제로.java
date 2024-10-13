import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < k; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0 && !s.isEmpty()){
                s.pop();
            }
            else{
                s.push(temp);
            }
        }
        int ret = 0;
        for(int i = 0; i < s.size(); i++){
            ret += s.get(i);
        }
        System.out.println(ret);
    }
}