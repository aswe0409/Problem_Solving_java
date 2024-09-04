import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < line.length(); i++){
            stack.push(line.charAt(i));

            //스택 크기가 폭발문자열 크기보다 크거나 같으면 스택 에 폭발문자열 있는지 탐색
            if(stack.size() >= bombLen){
                boolean status = true;
                for(int j = 0; j < bombLen; j++){
                    // 폭발 문자열이 없을 때
                    if(stack.get(stack.size() - bombLen + j) != bomb.charAt(j)){
                        status = false;
                        break;
                    }
                }
                // 폭발
                if(status){
                    for(int j = 0; j < bombLen; j++){
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(Character c : stack){
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}