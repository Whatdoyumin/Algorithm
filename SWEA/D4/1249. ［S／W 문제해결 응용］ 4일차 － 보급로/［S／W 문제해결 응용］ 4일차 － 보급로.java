import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static int[][] map;
    static int[][] dist;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r;
        int c;
        int cost;

        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();

                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }

                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            int answer = dijkstra();

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[0][0] = 0;
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 이미 더 좋은 비용으로 방문한 적 있으면 스킵
            if (cur.cost > dist[cur.r][cur.c]) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                int nextCost = cur.cost + map[nr][nc];

                if (nextCost < dist[nr][nc]) {
                    dist[nr][nc] = nextCost;
                    pq.offer(new Node(nr, nc, nextCost));
                }
            }
        }

        return dist[N - 1][N - 1];
    }
}