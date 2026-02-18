class Solution {
    public int solution(String s) {
        // 1개 이상 단위로 문자열을 잘라 압축한 것 중 가장 짧은 길이 return (최솟값) -> 그리디?
        // 문자의 개수와 반복되는 값으로 표현하여 압축
        // aabbaccc -> 2a2ba3c
        // ababcdcdababcdcd -> 2ab2cd2ab2cd
        
        int answer = Integer.MAX_VALUE;
        
        int minLength = s.length();
        
        // 1글자씩 잘라서 세보기 -> 글자수 늘려서 min 찾기
        // i : 자르는 글자수?
        for(int i = 1; i <= minLength; i++) {
            String prev = s.substring(0, 0 + i);
            int count = 1;
            
            // 그 압축된 글자 자체를 추출한 후 글자수 세지 않고
            // 바로 글자 수만 계산
            int resultLength = 0;
            
            for(int j = i; j + i <= minLength; j += i) {
                // 중복되는지 판단할 글자
                String cur = s.substring(j, j + i);
                
                // 현재 글자가 중복 판단 글자와 같으면 
                if (cur.equals(prev)) {
                    count++;
                } else {
                    // 이전 글자와 중복 없으면 이전 글자 길이 누적
                    resultLength += (count > 1 ? String.valueOf(count).length() + prev.length() : prev.length());
                    prev = cur;
                    count = 1;
                }
            }
            
            if(minLength % i != 0) resultLength += minLength % i;
            
            resultLength += (count > 1 ? String.valueOf(count).length() + prev.length() : prev.length());
            answer = Math.min(answer, resultLength);
        }
        
        
        return answer;
    }
}