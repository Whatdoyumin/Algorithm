class Solution {
    class Edge implements Comparable<Edge> {
        int node;
        int cost;

        Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return this.cost - other.cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = Integer.MAX_VALUE;

        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];

            graph.get(u).add(new Edge(v, w));
        }

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(k, 0));

        int[] dists = new int[n + 1];
        Arrays.fill(dists, INF);
        dists[k] = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            for(Edge next : graph.get(cur.node)) {
                // 현재를 거쳐서 다음으로 가는 최소 거리
                int nextDist = dists[cur.node] + next.cost;

                // 기존에 알고 있던 다음 거리랑 비교
                if (dists[next.node] > nextDist) {
                    pq.offer(new Edge(next.node, nextDist));
                    dists[next.node] = nextDist;
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(dists[i], max);
        }

        return (max == INF) ? -1 : max;
    }
}