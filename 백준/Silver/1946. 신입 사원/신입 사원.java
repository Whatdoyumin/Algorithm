
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] applicants = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken());
                applicants[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(applicants, Comparator.comparingInt(a -> a[0]));

            int maxCount = 0;
            int topRank = Integer.MAX_VALUE;

            for (int[] applicant : applicants) {
                int interviewRank = applicant[1];

                if (interviewRank < topRank) {
                    maxCount++;
                    topRank = interviewRank;
                }
            }
            sb.append(maxCount).append("\n");
        }

        System.out.println(sb);
    }
}
