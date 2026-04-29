import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[] dp = new int[length];
        int answer = Integer.MAX_VALUE;

        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < length; i++) {
            for(int j = triangle.get(i).size() - 1; j >= 0; j--) {
                if (j == i) { // 오른쪽 끝일 경우
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else if (j == 0) { // 왼쪽 끝일 경우
                    dp[j] = dp[j] + triangle.get(i).get(j);
                }
                else {
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j - 1]);
                }
            }
        }

        for(int d : dp) {
            answer = Math.min(answer, d);
        }

        return answer;
    }
}