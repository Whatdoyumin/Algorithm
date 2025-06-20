import java.util.*;

class Solution {
    int N, M;
    
    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;

        int[][] board = new int[N * 3][N * 3];

        // 자물쇠를 중앙에 배치
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i + N][j + N] = lock[i][j];
            }
        }

        // 키 회전 4번
        for (int rotate = 0; rotate < 4; rotate++) {
            key = rotateKey(key);

            for (int r = 0; r <= board.length - M; r++) {
                for (int c = 0; c <= board.length - M; c++) {
                    // 키 삽입
                    addKey(board, key, r, c, 1);

                    if (isUnlocked(board)) return true;

                    // 다시 빼기
                    addKey(board, key, r, c, -1);
                }
            }
        }

        return false;
    }

    void addKey(int[][] board, int[][] key, int r, int c, int sign) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                board[r + i][c + j] += key[i][j] * sign;
            }
        }
    }

    boolean isUnlocked(int[][] board) {
        for (int i = N; i < N * 2; i++) {
            for (int j = N; j < N * 2; j++) {
                if (board[i][j] != 1) return false;
            }
        }
        return true;
    }

    int[][] rotateKey(int[][] key) {
        int[][] rotated = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotated[j][M - 1 - i] = key[i][j];
            }
        }
        return rotated;
    }
}