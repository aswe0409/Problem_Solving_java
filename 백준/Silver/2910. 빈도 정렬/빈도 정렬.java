import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0)+ 1);
		}
		
		List<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));
		for(int key : list) {
			for(int i = 0; i < map.get(key); i++) {
				sb.append(key+" ");
			}
		}
		System.out.println(sb);
	}
}