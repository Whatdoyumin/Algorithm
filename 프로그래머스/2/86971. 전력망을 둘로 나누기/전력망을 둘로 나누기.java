import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // 트리 형태 만들기
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        //연결
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        int answer = Integer.MAX_VALUE;
        
        // 간선 끊어보며 확인
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            map.get(a).remove(Integer.valueOf(b));
            map.get(b).remove(Integer.valueOf(b));
            
            boolean[] visited = new boolean[n + 1];
            int count = dfs(a, map, visited);
            
            answer = Math.min(answer, Math.abs(count * 2 - n));
            
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        
        return answer;
    }
    
    int dfs(int start, Map<Integer, List<Integer>> map, boolean[] visited) {
       visited[start] = true;
        int count = 1;
        
        for(int node : map.get(start)) {
            if(!visited[node]) {
                count += dfs(node, map, visited);
            }
        }
        return count;
    }
}