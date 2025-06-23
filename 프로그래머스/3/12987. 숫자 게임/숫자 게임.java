import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int length = A.length;
        int answer = 0;
        int a = 0, b = 0;
        
        // 정렬 먼저
        Arrays.sort(A);
        Arrays.sort(B);
        
        while(a < length && b < length) {
            if(B[b] > A[a]) {
                answer++;
                a++;
            }
            b++;
        }
        
        return answer;
    }
}