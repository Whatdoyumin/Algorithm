import java.util.*;

class Solution {
    boolean[] visited;
    List<List<Integer>> graph;
    
    public int solution(int n, int[][] lighthouse) {
        // dfs로 풀기?
        visited = new boolean[n + 1];
        
        graph = new ArrayList<>();
        
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] arr : lighthouse) {
            int a = arr[0];
            int b = arr[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] answer = dfs(lighthouse[0][0]);
        
        return Math.min(answer[0], answer[1]);
    }
    
    private int[] dfs(int start) {
        visited[start] = true;

        int off = 0;
        int on = 1;

        for (int next : graph.get(start)) {
            if (visited[next]) {
                continue;
            }

            int[] child = dfs(next);

            // off 갱신
            off += child[1];
            
            // on 갱신
            on += Math.min(child[0], child[1]);
        }

        return new int[]{off, on};
    }
}