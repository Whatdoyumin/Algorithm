
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1260 DFS와 BFS
public class Main {
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        Dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        Bfs(V);

        System.out.println(sb.toString());
    }

    static void Dfs(int v) {
        visited[v] = true;
        // 재귀 사용
        sb.append(v).append(" ");
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] == 1 && !visited[i])
                Dfs(i);
        }
    }

    static void Bfs(int v) {
        q.add(v);
        visited[v] = true;
        // 큐 사용
        while (!q.isEmpty()) {
            v = q.poll();
            sb.append(v).append(" ");

            for (int i = 0; i < graph.length; i++) {
                if (graph[v][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
