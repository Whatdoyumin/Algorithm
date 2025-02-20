import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int mod=1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[][] = new int[k][n + 1];
        Arrays.fill(arr[0], 1);

        for (int i = 1; i < k; i++) {
            arr[i][0] = 1;
            for (int j = 1; j <= n; j++) {
                arr[i][j] = (arr[i - 1][j] + arr[i][j - 1])%mod;
            }
        }
        System.out.println(arr[k - 1][n]%mod);
    }
}