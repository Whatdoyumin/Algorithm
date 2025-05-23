import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int[] answers = new int[rocks.length];
        
        // 오름차순 정렬
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        
        // 각 바위 사이 거리의 최솟값 후보 구하기
        // -> 이분탐색
        while(left <= right) {
            int mid = (left + right) / 2;
            int cur = 0; // 현재 바위
            int removeCount = 0;    // 제거한 바위 개수
            
            for(int rock : rocks) {
                if(rock - cur < mid) removeCount++;
                else cur = rock;
            }
            
            if(distance - cur < mid) removeCount++;
            
            if(removeCount > n) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
        
        return answer;
    }
}