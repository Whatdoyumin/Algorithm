import java.util.*;

class Solution {
    int[] dr = {0, -1, 0, 1};
    int[] dc = {1, 0, -1, 0};
    int rowLength;
    
    class State {
        int r;
        int c;
        int cost;
        int dir;
        
        State(int r, int c, int cost, int dir) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.dir = dir;
        }
    }
    
    public int solution(int[][] board) {
        rowLength = board.length;
        
        // r, c, 코너별 금액
        int[][][] cost = new int[rowLength][rowLength][4];
        for(int[][] row : cost) {
            for(int[] r : row) {
                Arrays.fill(r, Integer.MAX_VALUE);
            }
        }
        
        // r, c, dist, 이전 방향 dir
        Queue<State> q = new LinkedList<>();
        
        // 초기 시작은 모든 방향으로 시작할 수 있도록
        for(int i = 0; i < 4; i++) {
            cost[0][0][i] = 0;
            q.offer(new State(0, 0, 0, i));
        }
        
        // visited: r, c, dir
        boolean[][][] visited = new boolean[rowLength][rowLength][4];
        
        
        while(!q.isEmpty()) {
            State cur = q.poll();
            int curR = cur.r;
            int curC = cur.c;
            int curCost = cur.cost;
            int dir = cur.dir;
            
            if(curR == rowLength - 1 && curC == rowLength - 1) {
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];
                
                if(isValid(nextR, nextC, board)) {
                    int nextCost = curCost;
                    if(dir == i) {
                        nextCost += 100;
                    } else {
                        nextCost += 600;
                    }
                    
                    if(cost[nextR][nextC][i] > nextCost) {
                        cost[nextR][nextC][i] = nextCost;
                        q.offer(new State(nextR, nextC, nextCost, i));
                    }
                }
            }
        }   
        
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minCost = Math.min(minCost, cost[rowLength - 1][rowLength - 1][i]);
        }
        return minCost;
    }
    
    boolean isValid(int r, int c, int[][] board) {
        return (r >= 0 && r < rowLength) && (c >= 0 && c < rowLength) && board[r][c] != 1;
    }
}