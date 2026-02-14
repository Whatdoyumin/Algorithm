class Solution {
    public int[] solution(String s) {
        // s가 1이 될 때까지 이진 변환을 했을 때, 제거된 모든 0의 개수를 각각 배열에 담아 return
        // 1. s의 모든 0 제거
        // 2. s = s의 길이를 2진법으로 표현한 문자열
        // (111111이면 각각 1 % 2 / 3 % 2 / 6 % 2 -> 1 1 0)
        StringBuilder sb = new StringBuilder();
        
        // 현재 길이
        int length = s.length();
        
        // 지운 0의 개수
        int total = 0;
        
        // 순회 횟수
        int num = 0;
        
        while(!s.equals("1")) {
            num++;
            String removed = s.replace("0", "");
            int removedCount = s.length() - removed.length();
            total += removedCount;
            length = s.replace("0", "").length();
            
            s = Integer.toBinaryString(length);
        }
        
        int[] answer = {num, total};
        return answer;
    }
}