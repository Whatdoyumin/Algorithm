class Solution {
    int answer = 0;
    boolean[] used;

    public int solution(int k, int[][] dungeons) {
        used = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }

    private void dfs(int fatigue, int[][] dungeons, int visitedCount) {
        if (visitedCount > answer) answer = visitedCount;

        for (int i = 0; i < dungeons.length; i++) {
            if (used[i]) continue;

            int need = dungeons[i][0]; 
            int cost = dungeons[i][1];

            if (fatigue >= need) {
                used[i] = true; 
                dfs(fatigue - cost, dungeons, visitedCount + 1);
                used[i] = false;
            }
        }
    }
}