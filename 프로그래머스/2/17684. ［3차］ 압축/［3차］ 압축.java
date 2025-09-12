import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 1. 사전 초기화 (A~Z)
        Map<String, Integer> dict = new HashMap<>();
        int dictIdx = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), dictIdx++);
        }

        List<Integer> result = new ArrayList<>();
        int nextIdx = 27; // 새 단어 등록 시작 번호
        int i = 0;

        // 2. 입력 탐색
        while (i < msg.length()) {
            String w = "" + msg.charAt(i);
            int j = i + 1;

            // 가장 긴 w 찾기
            while (j <= msg.length() && dict.containsKey(msg.substring(i, j))) {
                w = msg.substring(i, j);
                j++;
            }

            // w의 색인 번호 출력
            result.add(dict.get(w));

            // 다음 글자(c)가 있다면 w+c 등록
            if (j <= msg.length()) {
                String wc = msg.substring(i, j);
                if (!dict.containsKey(wc)) {
                    dict.put(wc, nextIdx++);
                }
            }

            // 입력 위치 갱신
            i += w.length();
        }

        // 3. 결과 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}