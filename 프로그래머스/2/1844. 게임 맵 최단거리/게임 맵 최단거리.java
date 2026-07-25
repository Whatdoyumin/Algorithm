import java.util.*;

class Solution {
    static int[] dr = new int[]{0, -1, 0, 1};
    static int[] dc = new int[]{1, 0, -1, 0};
    static int rowLength, colLength;
    
    public int solution(int[][] maps) {
        rowLength = maps.length;
        colLength = maps[0].length;
        
        boolean[][] visited = new boolean[rowLength][colLength];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            int dist = cur[2];
            
            if (curR == rowLength - 1 && curC == colLength - 1) {
                return dist;
            }
            
            for(int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];
                
                if (isValid(maps, nextR, nextC)) {
                    if (!visited[nextR][nextC]) {
                        q.add(new int[]{nextR, nextC, dist+1});
                        visited[nextR][nextC] = true;
                        
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean isValid(int[][] grid, int r, int c) {
        return (r >= 0 && r < rowLength) && (c >= 0 && c < colLength) && grid[r][c] == 1;
    }
}