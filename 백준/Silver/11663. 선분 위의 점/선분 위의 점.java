import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr1;
    static int result, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr1 = new int[N];

        // 점 좌표 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        StringBuilder sb = new StringBuilder();

        // 선분 입력 및 결과 계산
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            result = upperBound(arr1, y) - lowerBound(arr1, x);
            sb.append(result).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }

    static int lowerBound(int[] arr, int x) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    static int upperBound(int[] arr, int y) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= y) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
