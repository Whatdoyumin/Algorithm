import java.util.*;

class Solution {
    // 상, 우, 하, 좌
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static int rowLength = 0, colLength = 0;
    static boolean[][] visited;
    static int[][] grid;
        
    public int[] solution(String[] maps) {
        // 각 섬에 머무를 수 있는 최대 기간의 배열을 return하는 문제
        // 직사각형 지도의 X는 바다, 숫자는 무인도
        // 상, 하, 좌, 우로 연결된 하나의 무인도 숫자의 합이 최대 머무는 기간
        // 배열은 오름차순, 무인도 없으면 -1
        // bfs로 접근
        List<Integer> answer = new ArrayList<>();
        rowLength = maps.length;
        colLength = maps[0].length();
        grid = new int[rowLength][colLength];
        
        for (int i = 0; i < rowLength; i++) {
            String line = maps[i];
            for(int j  = 0; j < colLength; j++) {
                Character n = line.charAt(j);
                if (n == 'X') {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = n - '0';
                }
            }
        }
        
        visited = new boolean[rowLength][colLength];
        
        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++) {
                if(!visited[i][j] && isValid(i, j)) 
                    answer.add(bfs(i, j));
            }
        }
        
        if (answer.isEmpty()) return new int[]{-1};
        
        Collections.sort(answer);
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
    
    public int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        
        int sum = grid[r][c];
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];
                
                if (isValid(nextR, nextC) && !visited[nextR][nextC]) {
                    q.offer(new int[]{nextR, nextC});
                    sum += grid[nextR][nextC];
                    visited[nextR][nextC] = true;
                }
            }
        }
        return sum;
    }
    
    public boolean isValid(int r, int c) {
        return (r >= 0 && r < rowLength) && (c >= 0 && c < colLength) && grid[r][c] != 0;
    }
}