import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            int [] fibo0 = new int[41]; // fibo(0)이 호출되는 횟수 41로 초기화 한 이유는 n의 최대가 40이기 때문
            int [] fibo1 = new int[41];
            fibo0[0] = 1;
            fibo0[1] = 0;
            fibo1[0] = 0;
            fibo1[1] = 1;

            for(int i = 2; i <=n; i++){
                fibo0[i] = fibo0[i-1] + fibo0[i-2];
                fibo1[i] = fibo1[i-1] + fibo1[i-2];
            }
            System.out.println(fibo0[n]+" "+fibo1[n]);
        }
    }
}