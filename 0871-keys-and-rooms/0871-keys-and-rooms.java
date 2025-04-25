class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);

        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    void dfs(List<List<Integer>> graph, boolean[] visited, int current) {
        visited[current] = true;

        for (int next : graph.get(current)) {
            if (!visited[next]) {
                dfs(graph, visited, next);
            }
        }
    }
}