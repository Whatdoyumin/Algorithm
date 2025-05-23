import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // 최소 동전 개수를 구하므로 BFS
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        boolean[] visited = new boolean[amount + 1];
        visited[0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_amount = cur[0];
            int count = cur[1];

            // if 현재 노드 == amount -> return count;
            if(cur_amount == amount) return count;

            // 다음 노드 예약
            for(int coin : coins) {
                int next_amount = cur_amount + coin;
                if (next_amount >= 0 && next_amount <= amount && !visited[next_amount]) {
                    visited[next_amount] = true;
                    q.offer(new int[]{next_amount, count + 1});
                }
            }
        }

        return -1;
    }
}