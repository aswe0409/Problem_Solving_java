import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		HashSet<String> set = new HashSet<>();
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = i; j < str.length(); j++) {
				set.add(str.substring(i,j+1));
			}
		}
		System.out.println(set.size());
	}
}