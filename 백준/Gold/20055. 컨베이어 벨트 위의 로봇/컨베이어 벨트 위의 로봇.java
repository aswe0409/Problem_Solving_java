import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] belt = new int[2*N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] robots = new boolean[N];
        int cnt=0;
        int time=0;

        while(cnt<K) {

            // 1. rotate
            int temp = belt[2*N-1];
            for(int i=2*N-1; i>0; i--) {
                belt[i] = belt[i-1];
            }
            belt[0] = temp;
            for(int i=N-2; i>=0; i--) {
                if(robots[i]) {
                    robots[i+1] = true;
                    robots[i] = false;
                }
            }
            if(robots[N-1]) robots[N-1]=false;
            // 2. move robot
            for(int i=N-2; i>=0; i--) {
                if(!robots[i]) continue;
                if(belt[i+1]>0 && !robots[i+1]) {
                    robots[i+1]=true;
                    robots[i] = false;
                    belt[i+1]--;
                }
            }
            if(robots[N-1]) robots[N-1]=false;

            // 3. put robot
            if(belt[0]>0) {
                robots[0] = true;
                belt[0]--;
            }

            cnt=0;
            for(int i=0; i<2*N; i++) {
                if(belt[i]==0) cnt++;
            }
            time++;
        }
        System.out.println(time);
    }
}