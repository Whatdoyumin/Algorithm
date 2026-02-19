class Solution {
    public int[] solution(String s) {
        // s가 1이 될 때까지 계속해서 s에 이진 변환 가하기
        // 1. x의 모든 0 제거
        // 2. x = x의 길이를 2진법으로 바꾼 문자열
        // => 이진 변환 횟수, 제거된 모든 0의 개수 담아 return
        
        // 이진 변환 횟수
        int turn = 0;
        
        // 제거된 0 개수
        int count = 0;
        
        while (!s.equals("1")) {
            String str = s.replace("0", "");
            count += s.length() - str.length();
            
            s = Integer.toBinaryString(str.length());
            turn++;
        }
        
        return new int[]{turn, count};
    }
}