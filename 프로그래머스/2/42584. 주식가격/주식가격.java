import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty()) {
                int j = stack.peek();
                
                if(prices[j] > prices[i]) {
                    answer[j] = i - j;
                    stack.pop();
                }
                else {
                    break;
                }
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int i = stack.pop();
            answer[i] = prices.length - i - 1;
        }
        
        return answer;
    }
}