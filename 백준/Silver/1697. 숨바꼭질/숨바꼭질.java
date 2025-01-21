import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            visited[i] = false;
        }

        System.out.println(Bfs(N, K));
    }

    static int Bfs(int start, int end) {
        q.add(start);
        visited[start] = true;
        int seconds = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            // 각 초 단계별로 계산
            for (int i = 0; i < size; i++) {
                int current = q.poll();
                if (current == end) {
                    return seconds;
                }

                int[] nextItems = {current - 1, current + 1, current * 2};

                for (int next : nextItems) {
                    if (next >= 0 && next <= 100000 && !visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
            seconds++;

        }
        return seconds;
    }
}
