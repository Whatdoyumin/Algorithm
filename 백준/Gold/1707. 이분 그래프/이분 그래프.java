
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph;
    static int[] color;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }
            color = new int[V + 1];
            isBipartite = true;

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for (int j = 1; j <= V; j++) {
                if (color[j] == 0) {
                    if (!bfs(j)) {
                        isBipartite = false;
                        break;
                    }
                }
            }
            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString());
    }

    static boolean bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        color[v] = 1;


        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : graph.get(current)) {
                if (color[next] == 0) {
                    color[next] = -color[current];
                    q.add(next);
                } else if (color[next] == color[current]) {
                    return false;
                }
            }
        }
        return true;
    }
}
