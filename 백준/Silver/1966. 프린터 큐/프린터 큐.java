import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // 1. 현재 queue 가장 앞에 있는 문서의 중요도 확인
        // 2. 현재 문서보다 높은 문서가 있으면 back으로 보낸다 (다시 add한다)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer line1 = new StringTokenizer(br.readLine());
            N = Integer.parseInt(line1.nextToken());
            M = Integer.parseInt(line1.nextToken());

            arr = new int[N];
            StringTokenizer line2 = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                arr[n] = Integer.parseInt(line2.nextToken());
            }

            sb.append(getOrder(N, M, arr)).append("\n");
        }
        System.out.print(sb);
    }
    private static int getOrder(int N, int M, int[] arr) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            queue.add(new int[]{i, arr[i]});
        }

        int order = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (isHigherPriority(queue, cur[1])) {
                queue.add(cur);
            } else {
                order++;
                if (cur[0] == M) {
                    return order;
                }
            }
        }

        return -1;
    }

    private static boolean isHigherPriority(Queue<int[]> queue, int priority) {
        for (int[] doc : queue) {
            if (doc[1] > priority) {
                return true;
            }
        }
        return false;
    }
}
