import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[20][20];
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] == 0) continue;

                int player = board[i][j];

                for (int k = 0; k < 4; k++) {
                    int count = 1;

                    // 현재 위치 index 값
                    int nx = i, ny = j;

                    while (true) {
                        nx += dx[k];
                        ny += dy[k];

                        // 예외 처리 (보드판을 벗어나거나, 현재 플레이어와 색이 다를 경우)
                        if (nx < 0 || ny < 0 || nx >= 19 || ny >= 19 || board[nx][ny] != player) break;

                        count++;

                        if (count == 5) {
                            // 6목 이상일 경우 예외 처리
                            int px = i - dx[k];
                            int py = j - dy[k];
                            int qx = nx + dx[k];
                            int qy = ny + dy[k];

                            if ((px < 0 || py < 0 || px >= 19 || py >= 19 || board[px][py] != player) &&
                                    (qx < 0 || qy < 0 || qx >= 19 || qy >= 19 || board[qx][qy] != player)) {
                                sb.append(player).append("\n");
                                sb.append(i + 1).append(" ").append(j + 1);
                                System.out.println(sb);
                                return;
                            }


                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}
