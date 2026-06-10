class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int row;
    static int col;

    static class Result {

        boolean win;
        int count;

        public Result(boolean win, int count) {
            this.win = win;
            this.count = count;
        }
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {

        row = board.length;
        col = board[0].length;

        Result result = dfs(board, aloc[0], aloc[1], bloc[0], bloc[1]);

        return result.count;
    }

    private Result dfs(int[][] board, int ar, int ac, int br, int bc) {

        if (board[ar][ac] == 0) {
            return new Result(false, 0);
        }

        boolean canWin = false;

        int minCount = Integer.MAX_VALUE;
        int maxCount = 0;

        for (int d = 0; d < 4; d++) {

            int nr = ar + dr[d];
            int nc = ac + dc[d];

            if (nr < 0 || nc < 0 || nr >= row || nc >= col) {
                continue;
            }

            if (board[nr][nc] == 0) {
                continue;
            }

            board[ar][ac] = 0;

            Result next = dfs(board, br, bc, nr, nc);

            board[ar][ac] = 1;

            if (!next.win) {
                canWin = true;
                minCount = Math.min(minCount, next.count + 1);
            } else {
                maxCount = Math.max(maxCount, next.count + 1);
            }
        }

        if (canWin) {
            return new Result(true, minCount);
        }

        return new Result(false, maxCount);
    }
}