import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        // 각 횟수마다 만들 수 있는 Set을 저장
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            // N을 i번 이어붙인 수 추가
            int repeated = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeated);

            for (int j = 1; j < i; j++) {
                Set<Integer> leftSet = dp.get(j);
                Set<Integer> rightSet = dp.get(i - j);

                for (int a : leftSet) {
                    for (int b : rightSet) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }

            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}