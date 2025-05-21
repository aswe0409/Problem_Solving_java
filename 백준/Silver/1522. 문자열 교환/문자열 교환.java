import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int cntA = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a'){
                cntA += 1;
            }
        }
        
        int ret = 1001;
        for(int i = 0; i < str.length(); i++){
            int cntB = 0;
            for(int j = i; j < cntA+i; j++){
                if(str.charAt(j % str.length()) == 'b'){
                    cntB += 1;
                }
            }
            ret = Math.min(ret, cntB);
        }
        System.out.println(ret);
    }
}
