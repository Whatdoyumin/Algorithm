
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 축제가 열리는 기간 (마실 수 있는 맥주 수)
        int M = Integer.parseInt(st.nextToken()); // 채워야 하는 선호도의 합
        int K = Integer.parseInt(st.nextToken()); // 마실 수 있는 맥주 종류의 수

        List<int[]> beers = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 선호도
            int c = Integer.parseInt(st.nextToken()); // 도수 레벨
            beers.add(new int[]{c, v});
        }
        // 도수가 낮은 맥주부터 정렬
        beers.sort(Comparator.comparingInt(a -> a[0]));

        // 선호도 높은 맥주 N개를 유지하기 위한 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0; // 현재 선택한 N개의 선호도 합
        // 도수가 낮은 맥주부터 살펴보기
        for (int[] beer : beers) {
            int c = beer[0];    // 도수 레벨
            int v = beer[1];    // 선호도

            pq.offer(v);
            sum += v;

            if (pq.size() > N) {
                sum -= pq.poll();
            }
            if (pq.size() == N && sum >= M) {
                System.out.println(c);
                return;
            }
        }

        System.out.println(-1);
    }
}
