
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N, M = 0;
    // 최소 정사각형 크기 => 이후 최대값을 넣을 것.
    static int maxSize = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 가능한 최대 정사각형 크기
                int maxLength = Math.min(N - i, M - j);

                for (int k = 1; k < maxLength; k++) { // k는 현재 변의 길이, 점점 늘리면서 다 살펴보기
                    if (arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j + k]) {
                        maxSize = Math.max(maxSize, (k + 1) * (k + 1)); // 최대 값을 집어 넣기
                    }
                }
            }
        }
        System.out.println(maxSize);

    }

}
