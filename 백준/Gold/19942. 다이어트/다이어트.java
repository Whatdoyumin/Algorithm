import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] target = new int[4];
        int[][] food = new int[N][5];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                food[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minCost = Integer.MAX_VALUE;
        String answer = "";

        for (int mask = 1; mask < (1 << N); mask++) {
            int p = 0, f = 0, s = 0, v = 0, cost = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    p += food[i][0];
                    f += food[i][1];
                    s += food[i][2];
                    v += food[i][3];
                    cost += food[i][4];
                    sb.append(i + 1).append(" ");
                }
            }

            if (p >= target[0] && f >= target[1] && s >= target[2] && v >= target[3]) {
                String cur = sb.toString();

                if (cost < minCost) {
                    minCost = cost;
                    answer = cur;
                } else if (cost == minCost) {
                    if (answer.equals("") || cur.compareTo(answer) < 0) {
                        answer = cur;
                    }
                }
            }
        }

        if (minCost == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCost);
            System.out.println(answer);
        }
    }
}