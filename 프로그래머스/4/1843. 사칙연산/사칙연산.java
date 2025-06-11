class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        
        int[] nums = new int[n];
        String[] ops = new String[n - 1];
        
        // 숫자는 nums에, 기호는 ops에 저장
        for(int i = 0; i < arr.length; i++) {
            if(i % 2 == 0) {
                nums[i / 2] = Integer.parseInt(arr[i]);
            }
            else {
                ops[i / 2] = arr[i];
            }
        }
        
        // i부터 j까지 모든 구간의 최댓값, 최솟값 구하기
        int[][] maxDP = new int[n][n];
        int[][] minDP = new int[n][n];
        
        // 초기화
        for(int i = 0; i < n; i++) {
            maxDP[i][i] = nums[i];
            minDP[i][i] = nums[i];
        }
        
        // 2부터 전체까지 살펴보기
        for (int gap = 1; gap < n; gap++) { // 숫자 2개 사이 연산자 개수
            for (int start = 0; start + gap < n; start++) {
                int end = start + gap;
                maxDP[start][end] = Integer.MIN_VALUE;
                minDP[start][end] = Integer.MAX_VALUE;

                // 중간 지점 나누기
                for (int mid = start; mid < end; mid++) {
                    String op = ops[mid];

                    int[] candidates = new int[]{
                        calc(maxDP[start][mid], maxDP[mid + 1][end], op),
                        calc(maxDP[start][mid], minDP[mid + 1][end], op),
                        calc(minDP[start][mid], maxDP[mid + 1][end], op),
                        calc(minDP[start][mid], minDP[mid + 1][end], op)
                    };

                    for (int val : candidates) {
                        maxDP[start][end] = Math.max(maxDP[start][end], val);
                        minDP[start][end] = Math.min(minDP[start][end], val);
                    }
                }
            }
        }
        
        return maxDP[0][n-1];
    }
    
    private int calc(int a, int b, String op) {
        return op.equals("+") ? a + b : a - b;
    }
}