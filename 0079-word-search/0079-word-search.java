class Solution {
    static private int m, n;
    static private char[][] board;
    static private String word;
    static private boolean[][] visited;

    static private int[] dr = {0, 1, 0, -1};
    static private int[] dc = {1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;

        m = board.length;
        n = board[0].length;

        visited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (board[r][c] == word.charAt(0)) {
                    if (dfs(r, c, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, int idx) {

        if (board[r][c] != word.charAt(idx)) {
            return false;
        }

        if (idx == word.length() - 1) {
            return true;
        }

        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }

            if (visited[nr][nc]) {
                continue;
            }

            if (dfs(nr, nc, idx + 1)) {
                return true;
            }
        }

        visited[r][c] = false;

        return false;
    }
}