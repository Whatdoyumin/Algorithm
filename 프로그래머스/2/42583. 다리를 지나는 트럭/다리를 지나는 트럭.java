import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // bridge_length : 트럭이 다리에 올라갈 수 있는 최대 개수 (초)
        // weight: 다리가 견딜 수 있는 최대 무게
        // truck_weights : 대기 트럭
        // return 모든 트럭이 건너기 위한 최소 초
        // 매 초마다 트럭이 앞으로 한 칸씩
    
        // 최단 시간이면 큐?
        Queue<Integer> q = new ArrayDeque<>(bridge_length);
        for(int i = 0; i < bridge_length; i++) {
            q.add(0);
        }
        
        // 소요 초 시간
        int answer = 0;
        // 현재 다리 위의 무게
        int curWeight = 0;
        // 트럭 인덱스
        int truckIndex = 0;
        
        while (truckIndex < truck_weights.length || curWeight > 0) {
            answer++;
            
            int n = q.poll();
            // 다리 위 무게 + 다음 트럭 무게
            curWeight -= n;
            
            if (truckIndex < truck_weights.length) {
                int nextWeight = truck_weights[truckIndex];
                if (curWeight + nextWeight <= weight) {
                    q.add(nextWeight);
                    curWeight += nextWeight;
                    truckIndex++;
                } else {
                    q.add(0);
                }
            } else {
                q.add(0);
            }
        }
        
        
        return answer;
    }
}