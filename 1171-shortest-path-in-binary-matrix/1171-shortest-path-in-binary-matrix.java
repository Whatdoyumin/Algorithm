import java.util.*;

class Solution {
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    static boolean visited[][];

    public int shortestPathBinaryMatrix(int[][] grid) {
        int length = grid.length;
        visited = new boolean[length][length];

        if (grid[0][0] != 0 || grid[length -1][length - 1] != 0) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});    // row, col, distance
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int distance = cur[2];

            if (curRow == length - 1 && curCol == length - 1) return distance;

            for (int i = 0; i < 8; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

                if (isValid(nextRow, nextCol, grid, visited)) {
                    visited[nextRow][nextCol] = true;
                    q.offer(new int[]{nextRow, nextCol, distance + 1});
                }
            }
        }

        return -1;
    }

    boolean isValid(int r, int c, int[][] grid, boolean[][] visited) {
        return (r >= 0 && r < grid.length) 
            && (c >= 0 && c < grid.length) 
            && grid[r][c] == 0
            && !visited[r][c];
    }
}