import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for (int test = 0; test < TC; test++) {
			Deque<Integer> dq = new LinkedList<Integer>();
			String str = br.readLine();

			char[] order = new char[str.length()]; // 명령어 배열
			for (int i = 0; i < str.length(); i++) {
				order[i] = str.charAt(i);
			}

			int num = Integer.parseInt(br.readLine());
			String str1 = br.readLine();

			for (String s : str1.substring(1, str1.length() - 1).split(",")) {
				if (!s.equals("")) {
					dq.add(Integer.valueOf(s));
				}
			}
			int state = 0; // 0이면 정방향, 1이면 역방향

			boolean flag = false;
			for (int i = 0; i < order.length; i++) {
				if (order[i] == 'R') {
					state = 1 - state; // 상태 전환
				} else if (order[i] == 'D') {
					if (dq.isEmpty()) {
						System.out.println("error");
						flag = true;
						break;
					} else if (state == 0) {
						dq.pollFirst();
					} else {
						dq.pollLast();
					}
				}
			}

			if (flag)
				continue; // error 발생 시 다음 테스트 케이스로 넘어감

			StringBuilder sb = new StringBuilder("[");
			while (!dq.isEmpty()) {
				if (state == 1) { // 역방향일 때
					sb.append(dq.removeLast());
				} else { // 정방향일 때
					sb.append(dq.removeFirst());
				}
				if (dq.size() != 0)
					sb.append(',');
			}
			sb.append(']');
			System.out.println(sb.toString());
		}
	}
}