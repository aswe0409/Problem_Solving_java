//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        
//    }
//}


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] line = new int[n];
        boolean[] visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(st.nextToken()); // 나보다 큰 사람 수

            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    if (cnt == temp) {
                        line[j] = i;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(line[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
