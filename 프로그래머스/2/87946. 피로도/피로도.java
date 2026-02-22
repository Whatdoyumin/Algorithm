class Solution {
    static boolean[] visited;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        // k : 현재 피로도
        // 최소 필요 피로도: 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도
        // 소모 피로도: 던전을 탐험한 후 소모되는 피로도
        // 한 유저가 하루에 탐험할 수 있는 최대 던전의 수
        
        answer = 0;
        visited = new boolean[dungeons.length];
        
        dfs(0, dungeons, k);
        
        return answer;
    }
    
    public void dfs(int cur, int[][] dungeons, int k) {
        if (cur > answer) answer = cur;
            
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i]) continue;
            
            int need = dungeons[i][0];
            int consume = dungeons[i][1];
            
            if (k >= need) {
                visited[i] = true;
                dfs(cur + 1, dungeons, k - consume);
                visited[i] = false;
            }
        }
    }
}