import java.util.*;

class Solution {
    List<String> answer = new ArrayList<>();

    String[] phone = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return answer;
        }

        dfs(digits, 0, new StringBuilder());

        return answer;
    }

    private void dfs(String digits, int depth, StringBuilder sb) {
        if (depth == digits.length()) {
            answer.add(sb.toString());
            return;
        }

        int num = digits.charAt(depth) - '0';
        String letters = phone[num];

        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(digits, depth + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}