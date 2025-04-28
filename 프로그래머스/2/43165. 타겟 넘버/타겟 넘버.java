import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        // numbers의 조합으로 target을 만들 수 있는 경우의 수
        // BFS 이용
        
        int count = 0;
        
        Queue<Integer> queue = new LinkedList<>();  
        queue.add(0);
        
        for (int i = 0; i < numbers.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int total = queue.poll();
                queue.add(total + numbers[i]);
                queue.add(total - numbers[i]);
            }
        }
        
        while (!queue.isEmpty()) {
            if (queue.poll() == target) {
                count++;
            }
        }
        return count;
    }
}