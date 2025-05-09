class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int rowLength;
    static int colLength;

    public int numIslands(char[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;

        int count = 0;
        boolean[][] visited = new boolean[rowLength][colLength];

        for(int r = 0; r < rowLength; r++) {
            for(int c = 0; c < colLength; c++) {
                if(grid[r][c] == '1' && !visited[r][c]){
                    dfs(r, c, grid, visited);
                    count += 1;
                }
            }
        }

        return count;
    }

    void dfs(int r, int c, char[][] grid, boolean[][] visited) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int next_r = r + dr[i];
            int next_c = c + dc[i];
            if (isValid(next_r, next_c, grid)) {
                if (!visited[next_r][next_c]) {
                    dfs(next_r, next_c, grid, visited);
                }
            }
        }
    }

    boolean isValid(int r, int c, char[][] grid) {
        return (r >= 0 && r < rowLength) && (c >= 0 && c < colLength) && grid[r][c] == '1';
    }
}