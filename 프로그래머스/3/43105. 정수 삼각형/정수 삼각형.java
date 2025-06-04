import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int rowLength = triangle.length;

        // 각 인덱스의 누적합을 저장할 dp 배열
        int[][] dp = new int[rowLength][rowLength];

        dp[0][0] = triangle[0][0];

        for(int i = 1; i < rowLength; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if(j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < triangle[rowLength - 1].length; i++) {
            answer = Math.max(answer, dp[rowLength - 1][i]);
        }

        return answer;
    }
}