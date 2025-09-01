import java.util.*;

class Solution {
    static int N;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    
    public int solution(int[][] board) {
        N = board.length;
        
        return bfs(board);
    }
    
    static int bfs(int[][] board) {
        boolean[][][] visited = new boolean[N][N][2]; // r, c, dir (0 or 1)
        Queue<int[]> q = new ArrayDeque<>();

        if (!empty(board, 0, 0) || !empty(board, 0, 1)) return -1;
        visited[0][0][0] = true;
        q.offer(new int[]{0, 0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], dir = cur[2], d = cur[3];

            if (reachedGoal(r, c, dir)) return d;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (canMove(board, r, c, dir, dr[k], dc[k]) && !visited[nr][nc][dir]) {
                    visited[nr][nc][dir] = true;
                    q.offer(new int[]{nr, nc, dir, d + 1});
                }
            }

            // 회전
            if (dir == 0) {
                // 가로 → 세로 (위/아래로 회전)
                if (inBounds(r - 1, c) && inBounds(r - 1, c + 1)
                        && board[r - 1][c] == 0 && board[r - 1][c + 1] == 0) {
                    if (!visited[r - 1][c][1]) {
                        visited[r - 1][c][1] = true;
                        q.offer(new int[]{r - 1, c, 1, d + 1});
                    }
                    // 오른쪽 칸을 기준으로 위로 회전 → 기준점 (r - 1, c + 1), dir=1
                    if (!visited[r - 1][c + 1][1]) {
                        visited[r - 1][c + 1][1] = true;
                        q.offer(new int[]{r - 1, c + 1, 1, d + 1});
                    }
                }
                // 아래로 회전
                if (inBounds(r + 1, c) && inBounds(r + 1, c + 1)
                        && board[r + 1][c] == 0 && board[r + 1][c + 1] == 0) {
                    if (!visited[r][c][1]) {
                        visited[r][c][1] = true;
                        q.offer(new int[]{r, c, 1, d + 1});
                    }
                    if (!visited[r][c + 1][1]) {
                        visited[r][c + 1][1] = true;
                        q.offer(new int[]{r, c + 1, 1, d + 1});
                    }
                }
            } else {
                // 세로 → 가로 (좌/우로 회전)
                if (inBounds(r, c - 1) && inBounds(r + 1, c - 1)
                        && board[r][c - 1] == 0 && board[r + 1][c - 1] == 0) {
                    // 위쪽 칸을 축으로 왼쪽 회전 
                    if (!visited[r][c - 1][0]) {
                        visited[r][c - 1][0] = true;
                        q.offer(new int[]{r, c - 1, 0, d + 1});
                    }
                    // 아래쪽 칸을 축으로 왼쪽 회전
                    if (!visited[r + 1][c - 1][0]) {
                        visited[r + 1][c - 1][0] = true;
                        q.offer(new int[]{r + 1, c - 1, 0, d + 1});
                    }
                }
                // 오른쪽으로 회전
                if (inBounds(r, c + 1) && inBounds(r + 1, c + 1)
                        && board[r][c + 1] == 0 && board[r + 1][c + 1] == 0) {
                    // 위쪽 칸을 축으로 오른쪽 회전
                    if (!visited[r][c][0]) {
                        visited[r][c][0] = true;
                        q.offer(new int[]{r, c, 0, d + 1});
                    }
                    // 아래쪽 칸을 축으로 오른쪽 회전 
                    if (!visited[r + 1][c][0]) {
                        visited[r + 1][c][0] = true;
                        q.offer(new int[]{r + 1, c, 0, d + 1});
                    }
                }
            }
        }
        return -1;
    }

    // 평행 이동 가능 여부
    static boolean canMove(int[][] board, int r, int c, int dir, int mr, int mc) {
        if (dir == 0) {
            // 가로 
            int r1 = r + mr, c1 = c + mc;
            int r2 = r + mr, c2 = c + mc + 1;
            return empty(board, r1, c1) && empty(board, r2, c2);
        } else {
            // 세로 
            int r1 = r + mr, c1 = c + mc;
            int r2 = r + mr + 1, c2 = c + mc;
            return empty(board, r1, c1) && empty(board, r2, c2);
        }
    }

    // 목표 도달 여부
    static boolean reachedGoal(int r, int c, int dir) {
        if (dir == 0) {
            return (r == N - 1 && c == N - 1) || (r == N - 1 && c + 1 == N - 1);
        } else {
            return (r == N - 1 && c == N - 1) || (r + 1 == N - 1 && c == N - 1);
        }
    }

    // 칸이 비어있는지 
    static boolean empty(int[][] board, int r, int c) {
        return inBounds(r, c) && board[r][c] == 0;
    }

    static boolean inBounds(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

}