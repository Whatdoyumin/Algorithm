class Solution {
    static int[][] maps;
    
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        maps = new int[m][n];
        int[] answer = new int[2];
        int t = 0;
        
        int left = 0;
        int right = drops.length;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (check(drops, mid, m, n, h, w)) left = mid + 1;
            else right = mid - 1;
        }
        t = right;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                maps[i][j] = 0;
            }
        }
        
        for (int i = 0; i < t; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            maps[r][c] = 1;
        }

        int[][] sum = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = maps[i-1][j-1] 
                          + sum[i-1][j] 
                          + sum[i][j-1] 
                          - sum[i-1][j-1];
            }
        }

        for (int i = 0; i <= m - h; i++) {
            for (int j = 0; j <= n - w; j++) {
                int r1 = i, r2 = i + h - 1;
                int c1 = j, c2 = j + w - 1;

                int total = sum[r2+1][c2+1]
                          - sum[r1][c2+1]
                          - sum[r2+1][c1]
                          + sum[r1][c1];

                if (total == 0) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        
        return answer;
    }
    
    private boolean check(int[][] drops, int mid, int m, int n, int h, int w) {
        int[][] sum = new int[m+1][n+1];
    
        for(int i = 0; i < maps.length; i++) { 
            for(int j = 0; j < maps[0].length; j++) {
                maps[i][j] = 0;
            }          
        }
        
        for(int i = 0; i < mid; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            
            maps[r][c] = 1;
        }
        
        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                sum[i][j] = maps[i - 1][j - 1] + sum[i][j - 1] + sum[i - 1][j] - sum[i-1][j-1];
            }
        }
        
        for(int i = 0; i <= m - h; i++) {
            for(int j = 0; j <= n - w; j++) {
                int r1 = i, r2 = i + h - 1;
                int c1 = j, c2 = j + w - 1;
                
                int total = sum[r2+1][c2+1]
                              - sum[r1][c2+1]
                              - sum[r2+1][c1]
                              + sum[r1][c1];
                
                if(total == 0) return true;
            }
        }
        
        return false;
    }  
}