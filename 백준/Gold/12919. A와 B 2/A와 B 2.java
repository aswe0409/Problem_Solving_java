import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        
        rec(S, T);
        System.out.println(0);
    }
    
    static void rec(String s, String t){
        if(t.equals(s)){
            System.out.println(1);
            System.exit(0);
        }
        else if(s.length() > t.length()){
            return;
        }
        if (t.charAt(t.length() - 1) == 'A') {
                rec(s, t.substring(0, t.length() - 1));
            }

        if (t.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(t);
            String tempT = sb.reverse().toString();
            rec(s, tempT.substring(0, tempT.length() -1));
        }          
    }
}
