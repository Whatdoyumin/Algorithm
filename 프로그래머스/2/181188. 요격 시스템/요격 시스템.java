import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        // 모든 폭격 미사일을 요격하기 위한 미사일 최솟값
        // A 나라의 폭격 미사일 : (s, e) -> x축 평행 직선
        // B 나라 미사일: 해당 x좌표에 걸쳐있는 모든 폭격 미사일 모두 요격
        //              -> 단, s < x < e
        
        int answer = 0;
        Arrays.sort(targets, (a, b) -> {
            return a[1] - b[1];
        });
        
        // s < x < e를 만족하면 그 구간은 제거되고,
        // 가장 앞 구간에 포함되면 가장 유리
        
        // now는 끝점 직전
        int now = targets[0][1];
        for(int i = 1; i < targets.length; i++) {
            if (targets[i][0] >= now) {
                answer++;
                now = targets[i][1];
            }
        }

        return answer + 1;
    }
}