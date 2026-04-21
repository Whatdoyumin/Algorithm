import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] answer = new int[length - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < length; i++) {
            // nums[i]보다 작은 값들 dq 뒤에서 제거
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()])
                dq.pollLast();
            
            dq.addLast(i);

            // 현재 인덱스가 i - k + 1보다 작으면 제거
            if (dq.peekFirst() < (i - k + 1))
                dq.pollFirst();

            // 결과 저장
            if (i >= k - 1) {
                answer[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return answer;
    }
}