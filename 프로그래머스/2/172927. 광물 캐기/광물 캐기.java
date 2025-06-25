import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
            int answer = 0;
        int len = Math.min(minerals.length, (picks[0] + picks[1] + picks[2]) * 5);
        List<int[]> chunks = new ArrayList<>();

        // 5개씩 자르며 각 구간의 피로도(다이아, 철, 돌) 계산
        for (int i = 0; i < len; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5 && j < len; j++) {
                String m = minerals[j];
                if (m.equals("diamond")) {
                    dia += 1; iron += 5; stone += 25;
                } else if (m.equals("iron")) {
                    dia += 1; iron += 1; stone += 5;
                } else {
                    dia += 1; iron += 1; stone += 1;
                }
            }
            chunks.add(new int[]{dia, iron, stone});
        }

        // 다이아곡괭이 기준으로 가장 힘든 구간부터 처리
        chunks.sort((a, b) -> b[2] - a[2]);

        int idx = 0;
        for (int i = 0; i < picks[0] && idx < chunks.size(); i++, idx++) {
            answer += chunks.get(idx)[0]; // 다이아 곡괭이 → 다이아=1, 철=1, 돌=1
        }
        for (int i = 0; i < picks[1] && idx < chunks.size(); i++, idx++) {
            answer += chunks.get(idx)[1]; // 철 곡괭이
        }
        for (int i = 0; i < picks[2] && idx < chunks.size(); i++, idx++) {
            answer += chunks.get(idx)[2]; // 돌 곡괭이
        }

        return answer;
    }
}