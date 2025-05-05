import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] wire : wires) {
            int a = wire[0], b = wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int minDiff = Integer.MAX_VALUE;

        // 간선 하나씩 끊으면서 최소 차이 계산
        for (int[] wire : wires) {
            int a = wire[0], b = wire[1];

            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));

            boolean[] visited = new boolean[n + 1];
            int count = dfs(a, graph, visited);

            minDiff = Math.min(minDiff, Math.abs(n - 2 * count));

            // 복원
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return minDiff;
    }

    private int dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, graph, visited);
            }
        }
        return count;
    }
}