import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int n;
    static int [][] arr;
    static int minus = 0, zero = 0, one = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divied(0,0,n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }
    public static void divied(int row, int col, int size){
        if(check(row,col, size)){ //다 같은수 이면 해당 값 체크
            int num = arr[row][col];
            if(num == -1){
                    minus += 1;
                }
            if(num == 0){
                zero += 1;
            }
            if (num == 1){
                one += 1;
            }
            return;
        }
        else{//다 다른 수 이면 9분할
            int newSize = size / 3;
            for(int i = row; i < row + size; i+=newSize){
                for(int j = col; j < col + size; j+=newSize){
                    divied(i,j,newSize);
                }
            }
        }
    }
    public static boolean check(int row, int col, int size){
        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(arr[row][col] != arr[i][j]) { // 처음 요소랑 뒤에 나오는 요소가 다르면 다른 숫자가 있는거임
                    return false;
                }
            }
        }
        return true;
    }
}