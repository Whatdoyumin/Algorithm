class Solution {
    
    public int[] solution(int rows, int columns, int[][] queries) {
        // queries의 각 회전 요소 중 작은 숫자들을 배열에 담아 return
        // 각 숫자는 시계방향으로 회전
        // 1 ~ row*columns 행렬
        
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows + 1][columns + 1];
        int num = 1;
        for(int i = 1; i < rows + 1; i++) {
            for(int j = 1; j < columns + 1; j++) {
                arr[i][j] = num;
                num++;
            }
        }
        
        for(int k = 0; k < queries.length; k++) {
            int[] q = queries[k];
            
            int x1 = q[0];
            int y1 = q[1];
            int x2 = q[2];
            int y2 = q[3];
            
            int min = Integer.MAX_VALUE;
            int temp = arr[x1][y1];
            
            // 위쪽 가로 이동
            for(int j = y1; j < y2; j++) {
                int n = arr[x1][j];
                arr[x1][j] = temp;
                temp = n;
                min = Math.min(min, n);
            }
            
            // 오른쪽 세로 이동
            for(int i = x1; i < x2; i++) {
                int n = arr[i][y2];
                arr[i][y2] = temp;
                temp = n;
                min = Math.min(min, n);
            }
            
            // 아래쪽 가로 이동
            for(int j = y2; j > y1; j--) {
                int n = arr[x2][j];
                arr[x2][j] = temp;
                temp = n;
                min = Math.min(min, n);
            }
            
            // 왼쪽 세로 이동
            for(int i = x2; i > x1; i--) {
                int n = arr[i][y1];
                arr[i][y1] = temp;
                temp = n;
                min = Math.min(min, n);
            }
            
            arr[x1][y1] = temp;
            
            answer[k] = min;
        }
        
        return answer;
    }
}