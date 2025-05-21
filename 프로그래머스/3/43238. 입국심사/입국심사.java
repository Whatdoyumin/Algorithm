import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = times[times.length - 1] * (long)n;
        
        Arrays.sort(times);
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long people = 0;
            
            for(int i = 0; i < times.length; i++) {
                people += mid / times[i];
            }
            
            if(people < n) 
                left = mid + 1;
            else {
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}