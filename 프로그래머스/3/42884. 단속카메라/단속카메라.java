import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = Integer.MIN_VALUE;
        
        // 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1])); 
        
        for (int[] route : routes) {
            int in = route[0];
            int out = route[1];

            // 현재 카메라를 만나지 못하는 경우 카메라 개수 늘리기
            if (camera < in) {
                camera = out;
                answer++;
            }
        }

        return answer;
    }
}