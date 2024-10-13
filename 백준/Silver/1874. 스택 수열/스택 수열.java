import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        Stack<Integer> s = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int target = 1;
        for(int i = 0; i < n; i++){
            int temp = arr[i];
            if(temp >= target){
                while (temp >= target) {
                    s.push(target);
                    sb.append('+').append('\n');
                    target+=1;
                }
                s.pop();
                sb.append('-').append('\n');
            }
            else{
                int num = s.pop();
                if(num > temp){
                    System.out.println("NO");
                    System.exit(0);
                }
                else{
                    sb.append('-').append('\n');
                }
            }
        }
        System.out.println(sb.toString());
    }
}