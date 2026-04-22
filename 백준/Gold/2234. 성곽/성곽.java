import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {0, -1, 0, 1}; // 서, 북, 동, 남 
    static int[] dc = {-1, 0, 1, 0};
    static int[] wall = {1, 2, 4, 8};

    static int N, M;
    static int[][] grid, roomId;
    static boolean[][] visited;
    static Map<Integer, Integer> roomSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[M][N];
        visited = new boolean[M][N];

        roomId = new int[M][N];
        roomSize = new HashMap<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(roomSize.size());
        System.out.println(Collections.max(roomSize.values()));
        System.out.println(getMaxRoomSize());
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        int size = 0;
        // 새로운 방 번호
        int id = roomSize.size() + 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            size++;

            roomId[curR][curC] = id;
            
            for(int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];

                if (isValid(nextR, nextC) && !visited[nextR][nextC]) {
                    // 벽이 없는 경우
                    if ((grid[curR][curC] & wall[i]) == 0) {
                        visited[nextR][nextC] = true;
                        q.offer(new int[]{nextR, nextC});
                    }
                } 
            }
        }

        roomSize.put(id, size);
    }

    private static int getMaxRoomSize() {
        int max = 0;

        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                int currentRoomId = roomId[r][c];
                int currentRoomSize = roomSize.get(currentRoomId);

                for(int i = 0; i < 4; i++) {
                    int nextR = r + dr[i];
                    int nextC = c + dc[i];

                    if (isValid(nextR, nextC)) {
                        int nextRoomId = roomId[nextR][nextC];
                        int nextRoomSize = roomSize.get(nextRoomId);

                        // 다른 방이면서 벽이 있는 경우
                        if (currentRoomId != nextRoomId && (grid[r][c] & wall[i]) != 0) {
                            max = Math.max(max, currentRoomSize + nextRoomSize);
                        }
                    }
                }
            }
        }

        return max;
    }

    private static boolean isValid(int r, int c) {
        return ((r >= 0) && (r < M) && (c >= 0) && (c < N));
    }
}