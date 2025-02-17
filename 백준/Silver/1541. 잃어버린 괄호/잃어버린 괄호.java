import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();		
		String [] arr = str.split("-");
		
		// 더하기
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].contains("+")) {
				int temp = 0;
				String [] arr2 = arr[i].split("\\+");
				for(int j = 0; j < arr2.length; j++) {
					temp += Integer.parseInt(arr2[j]);
				}
				arr[i] = Integer.toString(temp);
			}
		}
		//빼기
		int ret = Integer.parseInt(arr[0]);
		
		if(arr.length > 1) {
			for(int i = 1; i < arr.length; i++) {
				ret -= Integer.parseInt(arr[i]);
			}
		}
		
		System.out.println(ret);
	}
}