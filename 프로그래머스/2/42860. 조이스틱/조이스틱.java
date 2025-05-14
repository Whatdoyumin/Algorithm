import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        // 각 자리에서 위, 아래 조작 최소 횟수
        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 좌우 이동 최소 거리 계산
        int move = length - 1;
        for (int i = 0; i < length; i++) {
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i * 2 + length - next);
            move = Math.min(move, (length - next) * 2 + i);
        }

        return answer + move;
    }
}
