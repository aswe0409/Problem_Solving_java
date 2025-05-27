import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Character> used = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            String [] word = str.split(" ");
            boolean state = false;
            
            //1 첫 단어 확인
            for(int j = 0; j < word.length; j++){
                char temp =  Character.toLowerCase(word[j].charAt(0));
                if(!used.contains(temp)){
                    used.add(temp);
                    word[j] = "[" + word[j].charAt(0) + "]" + word[j].substring(1);
                    state = true;
                    break;
                }
            }
            //위에서 못 찾앗으면 전체 탐색
            if (!state) {
                for (int j = 0; j < word.length; j++) {
                    for (int k = 0; k < word[j].length(); k++) {
                        char temp = Character.toLowerCase(word[j].charAt(k));
                        if (!used.contains(temp )) {
                            used.add(temp);
                            word[j] = word[j].substring(0, k) + "[" + word[j].charAt(k) + "]" + word[j].substring(k + 1);
                            state= true;
                            break;
                        }
                    }
                    if(state){
                            break;
                        }
                }
            }
            System.out.println(String.join(" ", word));
        }
    }
}
