import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        
        // 연결된 트리 구조 만들기
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        int answer = Integer.MAX_VALUE;
        
        // 간선 하나씩 끊어보면서 최소값 갱신
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            map.get(a).remove(Integer.valueOf(b));
            map.get(b).remove(Integer.valueOf(a));
            
            boolean[] visited = new boolean[n + 1];
            // dfs로 한 쪽 노드 개수 구하기
            int count = dfs(a, map, visited);
            
            answer = Math.min(answer, Math.abs(n - 2 * count));
            
            // 다시 간선 붙이기
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        return answer;
    }
    
    int dfs(int start, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[start] = true;
        int count = 1;
        
        for(int node : graph.get(start)) {
            if(!visited[node]) {
                count += dfs(node, graph, visited);
            }
        }
        return count;
    }
}