class Solution {
    static int[] arr;
    
    public int solution(int[] numbers, int target) {
        // 반복해서 확인하므로 재귀 -> dfs
        int sum = 0;
        arr = numbers;
        
        return dfs(0, sum, target);
    }
    
    public int dfs(int i, int sum, int target) {
        if (i == arr.length) {
            if (sum == target) return 1;
            else return 0;
        }
        
        return dfs(i+1, sum + arr[i], target)
                + dfs(i+1, sum - arr[i], target);
    }
}