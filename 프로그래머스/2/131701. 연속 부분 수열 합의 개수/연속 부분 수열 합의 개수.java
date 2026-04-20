import java.util.*;

class Solution {
    public int solution(int[] elements) {
        // 원형 수열
        // 연속 부분 수열 합으로 만들 수 있는 수의 개수
        
        Set<Integer> set = new HashSet<>();
        int length = elements.length;
        
        int[] arr = new int[length * 2];
        for(int i = 0; i < arr.length; i++) {
            if (i >= length) {
                arr[i] = elements[i - length];
            } else {
                arr[i] = elements[i];
            }
        }
        
        for(int k = 1; k < length + 1; k++) {
            int sum = 0;
            
            // 현재 합 더함
            for(int i = 0; i < k; i++) {
                sum += arr[i];
            }
            
            set.add(sum);
            
            for(int i = 0; i < length; i ++) {
                sum += arr[i + k];
                sum -= arr[i];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}