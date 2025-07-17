
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int target = Integer.parseInt(br.readLine());

    int[][] arr = new int[N][N];
    int x = 0, y = 0, dir = 0;
    int num = N * N;
    int targetRow = 0, targetCol = 0;

    while (num >= 1) {
      arr[x][y] = num;
      if (num == target) {
        targetRow = x;
        targetCol = y;
      }

      int nx = x + dr[dir];
      int ny = y + dc[dir];

      if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] != 0) {
        dir = (dir + 1) % 4;
        nx = x + dr[dir];
        ny = y + dc[dir];
      }

      x = nx;
      y = ny;
      num--;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sb.append(arr[i][j]).append(" ");
      }
      sb.append("\n");
    }

    sb.append((targetRow + 1)).append(" ").append((targetCol + 1));
    System.out.println(sb);
  }
}