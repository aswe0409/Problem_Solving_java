import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (int temp : arr) {
            if (dq.isEmpty() || dq.peekLast() != temp) {
                dq.offer(temp);
            }
        }

        int[] answer = new int[dq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = dq.poll();
        }

        return answer;
    }
}
