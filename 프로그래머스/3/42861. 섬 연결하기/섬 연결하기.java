import java.util.*;

class Edge {
    int from;
    int to;
    int weight;

    Edge (int f, int t, int w) {
        this.from = f;
        this.to = t;
        this.weight = w;
    }
}
    
class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        // 모든 섬이 서로 통행 가능하도록 만드는 최소 비용
        // 도달할 수만 있으면 다리 여러 번 건너기 가능
        int answer = 0;
        parent = new int[n];
        
        List<Edge> graph = new LinkedList<>();
        for(int[] cost : costs) {
            graph.add(new Edge(cost[0], cost[1], cost[2]));
        }
        
        graph.sort((a, b) -> 
            a.weight - b.weight
        );
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(Edge e : graph) {
            int rootA = find(e.from);
            int rootB = find(e.to);
            
            if (rootA != rootB) {
                // 부모 연결
                parent[rootB] = rootA;
                // answer 더해
                answer += e.weight;
            }
        }
        
        return answer;
    }
    
    public int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
}