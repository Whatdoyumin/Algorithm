class Solution {

    public int solution(String s) {
        int answer = 1;

        for (int center = 0; center < s.length(); center++) {
            // 홀수
            int oddLength = expand(s, center, center);
            // 짝수
            int evenLength = expand(s, center, center + 1);

            answer = Math.max(answer, Math.max(oddLength, evenLength));
        }

        return answer;
    }

    private int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return (right - 1) - (left + 1) + 1;
    }
}