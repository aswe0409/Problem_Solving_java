import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;          // 가벼운 사람도 같이 탑승
            }
            right--;             // 무거운 사람은 무조건 탑승
            answer++;
        }
        return answer;
    }
}