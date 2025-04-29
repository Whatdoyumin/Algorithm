import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // 최소 동전 개수를 구하므로 BFS
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        q.add(0);
        visited.add(0);

        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int sum = q.poll();

                if (sum == amount) {
                    return count;
                }

                for (int coin : coins) {
                    int next = sum + coin;
                    if (next <= amount && !visited.contains(next)) {
                        q.add(next);
                        visited.add(next);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}