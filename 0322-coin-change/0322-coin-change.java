class Solution {
    public int coinChange(int[] coins, int amount) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{amount, 0});

        boolean[] visited = new boolean[amount + 1];
        visited[amount] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curAmount = cur[0];
            int curCount = cur[1];
            
            if(curAmount == 0) {
                return curCount;
            }

            for(int coin : coins) {
                int next = curAmount - coin;

                if(next >= 0 && !visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, curCount + 1});
                }
            }
        }

        return -1;
    }
}