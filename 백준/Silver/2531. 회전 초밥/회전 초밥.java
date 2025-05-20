import java.io.*;
import java.util.*;

// for문 돌아 dq 사이즈가 k 랑 같으면 set에 넣어
// set반복 하면서 사이즈 젤 큰에 인덱스 기억해
// 인덱스 접근해서 해당 값에 쿠폰 초밥 없으면 + 1하고 출력
// 아니면 그냥 size 출력

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] belt = new int[n + k];
        for (int i = 0; i < n; i++) {
            belt[i] = arr[i];
        }
        for (int i = 0; i < k; i++) {
            belt[n + i] = arr[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = 0;

        for (int i = 0; i < k; i++) {
            dq.addLast(belt[i]);
            countMap.put(belt[i], countMap.getOrDefault(belt[i], 0) + 1);
        }

        if (!countMap.containsKey(c)) {
            max = countMap.size() + 1;
        } else {
            max = countMap.size();
        }

        for (int i = 1; i < n; i++) {
            int removed = dq.pollFirst();
            countMap.put(removed, countMap.get(removed) - 1);
            if (countMap.get(removed) == 0) {
                countMap.remove(removed);
            }

            int added = belt[i + k - 1];
            dq.addLast(added);
            countMap.put(added, countMap.getOrDefault(added, 0) + 1);

            int typeCount = countMap.size();
            if (!countMap.containsKey(c)) {
                typeCount++;
            }

            max = Math.max(max, typeCount);
        }

        System.out.println(max);
    }
}
