class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int i = 3; i < sum; i++) {
            if (sum % i == 0) {
                int j = sum / i;
                
                if ((i - 2) * (j - 2) == yellow) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        return answer;
    }
}