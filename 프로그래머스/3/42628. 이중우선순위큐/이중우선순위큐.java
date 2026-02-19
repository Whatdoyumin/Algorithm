import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 연산이 주어지면, 모든 연산 처리 후
        // 큐가 비어 잇으면 [0, 0], 비어있지 않으면 [최댓값, 최솟값]
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String o : operations) {
            if (o.startsWith("I")) {
                String num = o.substring(2, o.length());
                minHeap.add(Integer.parseInt(num));
                maxHeap.add(Integer.parseInt(num));
            } else if (o.equals("D 1")) {
                if (!maxHeap.isEmpty()) {
                    int n = maxHeap.poll();
                    minHeap.remove(n);
                }
            } else if (o.equals("D -1")) {
                if (!minHeap.isEmpty()) {
                    int n = minHeap.poll();
                    maxHeap.remove(n);
                }
            }
        }
        
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{maxHeap.peek(), minHeap.peek()};
    }
}