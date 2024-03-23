package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_톱니바퀴 {

    static int K, ans;
    static int[][] w;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        w = new int[5][9];
        d= new int[5];

        for (int i = 1; i <= 4; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                w[i][j + 1] = arr[j] - '0';
            }
        } // 톱니바퀴의 상태 입력완 (1로 설정하기)

        // k번 동안 해야하는 일..
        // 입력 받은 바퀴를 시계 방향 or 반시계 방향으로 돌리고
        // 그 옆의 것도 살펴보기

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        for (int j = 0; j < K; j++) {
            st = new StringTokenizer(br.readLine());
            int wheel = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            d[wheel]=dir; //입력 받은 것의 방향은 미리 저장

            //좌
            for(int i=1; i<wheel; i++) {
                if(wheel-i>0  && i%2==1 && w[wheel-i+1][7] !=w[wheel-i][3]) {
                    d[wheel-i]=-dir;
                    System.out.println(wheel-i);
                } else if(wheel-i>0&& i%2==0  && w[wheel-i+1][7] !=w[wheel-i][3]) {
                    d[wheel-i]=dir;
                    System.out.println(d[wheel-i]);
                } else break;
            }

            //우
            for(int i=1; i<=4-wheel; i++) {
                if(wheel+i<5 && i%2==1 && w[wheel+i-1][3] !=w[wheel+i][7]) {
                    d[wheel+i]=-dir;
                } else if(wheel+i<5 && i%2==0 && w[wheel+i-1][3] !=w[wheel+i][7]) {
                    d[wheel+i]=dir;
                } else break;
//                System.out.println(d[wheel+i]);
            }
//            System.out.println(Arrays.toString(d));
            //이렇게 되면 모든 바퀴의 방향이 d안에 저장이 됨 1~4까지
            //돌리기
            for(int i=1; i<=4; i++) {
                if(d[i]==1) turnClockDir(i);
                else if(d[i]==-1) turnCounterDir(i);
//                System.out.println(i+"---");
//                for(int l=1; l<=4; l++) {
//                    System.out.println(Arrays.toString(w[l]));
//                }
            }
        }

        //점수를 계산해야됨
        if (w[1][1] == 1) {
            ans += 1;
        }
        if (w[2][1] == 1) {
            ans += 2;
        }
        if (w[3][1] == 1) {
            ans += 4;
        }
        if (w[4][1] == 1) {
            ans += 8;
        }

        System.out.println(ans);

    }


    // 반시계 방향으로 돌리기
    static void turnCounterDir(int wheel) {
        int tmp=w[wheel][1];
        for(int i=1; i<8; i++) {
            w[wheel][i]=w[wheel][i+1];
        }
        w[wheel][8]=tmp;
    }

    // 시계 방향으로 돌리기
    static void turnClockDir(int wheel) {
        int tmp=w[wheel][8];
        for(int i=8; i>1; i--) {
            w[wheel][i]=w[wheel][i-1];
        }
        w[wheel][1]=tmp;
    }
}
