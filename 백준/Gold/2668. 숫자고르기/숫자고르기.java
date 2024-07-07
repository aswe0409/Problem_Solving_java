import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n;
    static int []arr;
    static boolean [] visit;
    static List<Integer> ans = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visit = new boolean[n+1];

        for(int i = 1; i < n+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i < n+1; i++){
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
    static void dfs(int idx, int start){
        if(!visit[arr[idx]]){
            visit[arr[idx]] = true;
            dfs(arr[idx], start);
            visit[arr[idx]] = false;
        }
        if(arr[idx] == start){ //처음 값과 탐색하면서 만나는 값이 같으면 사이클 완성
            ans.add(start);
        }
    }
}