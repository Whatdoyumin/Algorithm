import java.util.*;

class Solution {
    int[] dr = {0, -1, 0, 1};
    int[] dc = {1, 0, -1, 0};
    int rowLength, colLength;
    
    public int solution(int[][] maps) {
        rowLength = maps.length;
        colLength = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        
        boolean[][] visited = new boolean[rowLength][colLength];
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int dist = cur[2];
            
            if(curRow == rowLength - 1 && curCol == colLength - 1)
                return dist;
            
            for(int i = 0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                
                if(isValid(nextRow, nextCol, maps)) {
                    if(!visited[nextRow][nextCol]) {
                        q.offer(new int[]{nextRow, nextCol, dist + 1});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        return -1;
    }
    
    boolean isValid(int r, int c, int[][] maps) {
        return (r >= 0 && r < maps.length) && (c >= 0 && c < maps[0].length) && maps[r][c] == 1;
    }
}