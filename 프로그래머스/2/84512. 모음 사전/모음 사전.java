import java.util.*;

class Solution {
    public int solution(String word) {
        String[] vowels = {"A", "E", "I", "O", "U"};
        Queue<String> q = new PriorityQueue<>();
        q.add("");

        int count = 0;
        while (!q.isEmpty()) {
            String current = q.poll();

            if (!current.isEmpty()) {
                count++;
                if (current.equals(word)) {
                    return count;
                }
            }

            if (current.length() < 5) {
                for (String v : vowels) {
                    q.add(current + v);
                }
            }
        }

        return -1;
    }
}