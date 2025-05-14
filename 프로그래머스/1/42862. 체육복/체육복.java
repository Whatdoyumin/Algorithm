import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 옷 사용했는지
        boolean[] usedReserve = new boolean[reserve.length];
        // 도난당한 체육복 빌렸는지
        boolean[] recovered = new boolean[lost.length];
        
        // 도난당한 학생이면서 여벌 옷이 있는 학생 예외 처리
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    usedReserve[j] = true;
                    recovered[i] = true;
                    break;
                }
            }
        }
        
        for(int i = 0; i < lost.length; i++) {
            if(recovered[i]) continue;
            
            for(int j = 0; j < reserve.length; j++) {
                if(usedReserve[j]) continue;
                
                if(reserve[j] == lost[i] + 1 || reserve[j] == lost[i] - 1) {
                    answer++;
                    reserve[j] = 0;
                    break;
                }
            }
            
        }
        
        return answer;
    }
}