class Solution {
    static boolean[] visited;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, int cur) {
        if (cur > answer) answer = cur;
        
        for(int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            
            int need = dungeons[i][0];
            int consume = dungeons[i][1];
            
            if (k >= need) {
                visited[i] = true;
                dfs(k - consume, dungeons, cur + 1);
                visited[i] = false;
            }
        }
    }
}