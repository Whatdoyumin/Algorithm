public class Solution {
    public int solution(String s) {
        int minLength = s.length();

        for (int step = 1; step <= s.length() / 2; step++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, step);
            int count = 1;

            for (int j = step; j < s.length(); j += step) {
                int end = Math.min(j + step, s.length());
                String current = s.substring(j, end);

                if (current.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed.append(count);
                    }
                    compressed.append(prev);
                    prev = current;
                    count = 1;
                }
            }

            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);

            minLength = Math.min(minLength, compressed.length());
        }

        return minLength;
    }
}