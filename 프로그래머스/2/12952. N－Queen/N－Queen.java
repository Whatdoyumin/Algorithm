class Solution {
    static int answer;
    static int[] row;
    static int length;
    
    public int solution(int n) {
        answer = 0;
        row = new int[n];
        length = n;
        
        dfs(0);
        
        return answer;
    }
    
    public void dfs(int r) {
        // 행 인덱스 r
        if (r == length) {
            answer++;
            return;
        }
        
        // j는 현재 행에 놓을 열
        // 각 행의 열들을 보겠다.
        for(int j = 0; j < length; j++) {
            // r행의 j번에 퀸
            row[r] = j;
            
            boolean isValid = true;
            
            // 이전 행과 비교
            for(int i = 0; i < r; i++) {
                // 같은 행일 경우
                if(row[i] == row[r])
                    isValid = false;
                
                // 대각선일 경우
                if (Math.abs(row[i] - row[r]) == Math.abs(i - r))
                    isValid = false;
            }
            
            if (isValid) dfs(r + 1);
        }
    }
}