import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken()); // 걸그룹수
		int m = Integer.parseInt(st.nextToken()); // 문제 수
		
		HashMap<String, List<String>> map = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			String group = br.readLine();
			int cnt = Integer.parseInt(br.readLine());
			map.put(group, new ArrayList<>());
			
			for(int j = 0; j < cnt; j++) {
				String name = br.readLine();
				map.get(group).add(name);
			}
		}
		
		//문제 맞추기
		for(int i = 0; i < m; i++) {
			String name = br.readLine();
			int type = Integer.parseInt(br.readLine());
			
			//멤버이름 사전준
			if(type == 0) {
				List<String> arr = new ArrayList<>(map.getOrDefault(name, new ArrayList<>()));
		        Collections.sort(arr);
				for(String temp : arr) {
					sb.append(temp+"\n");
				}
			}
			
			//멤버 수
			else {
				for(String key : map.keySet()) {
					for(String value : map.get(key)) {
						if(value.equals(name)) {
							sb.append(key+ "\n");
						}
					}
				}
			}
		}
		System.out.println(sb);
	}
}