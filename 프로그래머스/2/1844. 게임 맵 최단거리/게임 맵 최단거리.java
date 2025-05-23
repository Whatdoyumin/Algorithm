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
            // 현재 노드 방문
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int dist = cur[2];
            
            // if 도착지 도착하면 dist 반환
            if(curRow == rowLength - 1 && curCol == colLength - 1) return dist;
            
            // 다음 노드 예약
            for(int i = 0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                if((nextRow >= 0 && nextRow < rowLength) && (nextCol >= 0 && nextCol < colLength)) {
                    if(!visited[nextRow][nextCol] && maps[nextRow][nextCol] == 1) {
                        visited[nextRow][nextCol] = true;
                        q.offer(new int[]{nextRow, nextCol, dist+1});
                    }
                } 
            }
        }
        
        return -1;
        
    }
}