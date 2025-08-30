import java.util.*;

class Solution {
    static int[] dist = new int[0];
    
    public int solution(int n, int[][] edge) {
        int answer = 0, maxDist = -1;
        
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edge) {
            int a = e[0], b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        bfs(1, graph);
        
        for(int i = 1; i <= n; i++) {
            int d = dist[i];
            if(d > maxDist) {
                maxDist = d;
                answer = 1;
            } else {
                if (d == maxDist) answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int start, List<Integer>[] graph) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int next : graph[cur]) {
                if(dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}