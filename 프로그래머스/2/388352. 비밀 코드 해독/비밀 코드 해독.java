class Solution {

    int answer = 0;

    public int solution(int n, int[][] q, int[] ans) {

        int[] selected = new int[5];

        dfs(1, 0, n, selected, q, ans);

        return answer;
    }

    private void dfs(int start, int depth, int n,
                     int[] selected, int[][] q, int[] ans) {

        if (depth == 5) {

            boolean possible = true;

            for (int i = 0; i < q.length; i++) {

                int match = 0;

                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (selected[j] == q[i][k]) {
                            match++;
                        }
                    }
                }

                if (match != ans[i]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                answer++;
            }

            return;
        }

        for (int num = start; num <= n; num++) {
            selected[depth] = num;
            dfs(num + 1, depth + 1, n, selected, q, ans);
        }
    }
}