import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int max, sum, start, end, result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        start = max;
        end = sum;
        result = sum;

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 1;
            int currentSum = 0;

            for (int i = 0; i < N; i++) {
                if (currentSum + arr[i] > mid) {
                    count++;
                    currentSum = arr[i];
                } else {
                    currentSum += arr[i];
                }
            }

            if (count <= M) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
