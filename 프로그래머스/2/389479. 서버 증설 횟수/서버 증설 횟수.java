class Solution {
    public int solution(int[] players, int m, int k) {
        // 게임 이용 인원 m명 늘어날 때마다 서버 1대 더 필요
        // m명 미만이면 증설 X
        // n*m명 이상 (n + 1) * m명 미만이면 최소 n대 증설되어야 함
        // 한 번 증설하면 k시간 동안 운영, 그 다음 반납
        // => 하루(24시간)동안 모든 이용자가 게임하기 위한 최소 증설 횟수
        int answer = 0;
        int running = 0;
        int[] expire = new int[players.length];
        
        for (int i = 0; i < players.length; i++) {
            // p: 시간대별 게임 이용자 수
            int p = players[i];
            
            // 현재 운영 중인 서버 수 확인
            running -= expire[i];
            
            // n: 필요한 서버 수
            int n = p / m;
            
            
            if (running < n) {
                // add: 추가할 애
                int add = n - running;
                answer += add;
                running += add;
                
                // 만료될 애 추가
                if (i + k < players.length) {
                    expire[i + k] += add;
                }
            } 
        }
        
        return answer;
    }
}