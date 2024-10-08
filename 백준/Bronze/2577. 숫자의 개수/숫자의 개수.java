import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String num = Integer.toString(A*B*C);
        int [] arr = new int[10];

        for(int i = 0; i < num.length(); i++){
            for(int j = 0; j < 10; j++){
                if(j == (num.charAt(i)- '0')){
                    arr[j] += 1;
                    break;
                }
            }
        }

        for(int i = 0; i < 10; i++){
            System.out.println(arr[i]);
        }
    }
}