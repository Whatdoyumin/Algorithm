import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 연결된 트리 생성
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        // 연결
        for(int[] wire : wires) {
            int a = wire[0]; 
            int b = wire[1];
            
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        // 간선 하나씩 끊으면서 살펴보기
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            // 간선 끊기
            map.get(a).remove(Integer.valueOf(b));
            map.get(b).remove(Integer.valueOf(a));
            
            boolean[] visited = new boolean[n + 1];
            int count = dfs(a, map, visited);
            
            answer = Math.min(answer, Math.abs(2 * count - n));
            
            // 다시 이어 붙이기
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        return answer;
    }
    
    // 연결된 애들 개수 구하기
    int dfs(int start, Map<Integer, List<Integer>> map, boolean[] visited) {
        visited[start] = true;
        int count = 1;
        
        for(int node : map.get(start)) {
            if(!visited[node]) 
                count += dfs(node, map, visited);
        }
        return count;
    }
}