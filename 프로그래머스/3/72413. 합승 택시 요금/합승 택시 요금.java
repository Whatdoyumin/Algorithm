import java.util.*;

class Solution {
    static final int INF = 200_000_000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n + 1][n + 1];

        // 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 요금 테이블 적용
        for (int[] fare : fares) {
            int u = fare[0], v = fare[1], cost = fare[2];
            dist[u][v] = cost;
            dist[v][u] = cost;
        }

        // 플로이드 워셜 활용
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 경유하는 지점마다 비용 계산
        int answer = INF;
        for (int k = 1; k <= n; k++) {
            int total = dist[s][k] + dist[k][a] + dist[k][b];
            answer = Math.min(answer, total);
        }

        return answer;
    }
}