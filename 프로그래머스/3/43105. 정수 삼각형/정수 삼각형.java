import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int rowLength = triangle.length;
        
        // 각 인덱스의 누적합 저장
        int[][] dp = new int[rowLength][rowLength];
        
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < rowLength; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                int cur = triangle[i][j];
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + cur;
                } else if(j == triangle[i].length - 1) {
                    dp[i][j] = dp[i-1][j-1] + cur;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + cur;
                }
            }
        }
        
        for(int i = 0; i < triangle[rowLength - 1].length; i++) {
            answer = Math.max(answer, dp[rowLength - 1][i]);
        }
        
        return answer;
    }
}