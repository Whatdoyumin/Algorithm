class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // dp로 풀래요
        
        // dp[i][j] = (i, j)로 오는 경우의 수
        // 근데 이걸 어떻게 생각해내는거냐고
        
        boolean[][] isPuddle = new boolean[m + 1][n + 1];
        for(int[] puddle : puddles) {
            int a = puddle[0];
            int b = puddle[1];
            
            isPuddle[a][b] = true;
        }
        
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;       
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (isPuddle[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if (i == 1 && j == 1) continue;
                
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
        
        return dp[m][n];
    }
}