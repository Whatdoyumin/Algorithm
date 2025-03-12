
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count = 0;
    static boolean[][] map;
    static Deque<int[]> dq = new ArrayDeque<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = split[j].equals("1");
            }
        }

        System.out.println(bfs(0,0));

    }

    static int bfs(int x, int y) {
        dq.add(new int[]{0, 0, 1});

        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cdis = cur[2];  // 위치
            if(cx == N - 1 && cy == M-1) {
                count = cdis;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (isValid(nx, ny) && map[nx][ny]) {
                    map[nx][ny] = false;
                    count = cdis + 1;
                    dq.offer(new int[]{nx, ny, count});
                }
            }
        }
        return count;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
