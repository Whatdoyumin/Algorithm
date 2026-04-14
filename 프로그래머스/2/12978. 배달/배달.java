import java.util.*;

class Node {
    int node;
    int weight;
    
    Node(int n, int w) {
        this.node = n;
        this.weight = w;
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] r : road) {
            int from = r[0];
            int to = r[1];
            int weight = r[2];
            
            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }
        
        int[] dist = new int[N + 1];
        for(int i = 1; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
        
        Queue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        pq.add(new int[]{1, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            
            if (curDist > dist[curNode]) continue;
            
            for(Node next : graph.get(curNode)) {
                int nextNode = next.node;
                int weight = next.weight;
                
                int newDist = curDist + weight;
                if(newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }
        
        for(int i = 1; i < N+1; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
}