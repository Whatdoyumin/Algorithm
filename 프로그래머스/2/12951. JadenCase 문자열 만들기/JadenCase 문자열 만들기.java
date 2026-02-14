class Solution {
    public String solution(String s) {
        // split(" ")으로 할 경우 공백 문자 처리가 불가함
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(s.charAt(0)));
        
        for(int i = 1; i < s.length(); i++) {
            Character prev = s.charAt(i - 1);
            Character now = s.charAt(i);
            
            if(prev == ' ') {
                now = Character.toUpperCase(now);
            } else {
                now = Character.toLowerCase(now);
            }
            
            sb.append(now);
        }
        
        return sb.toString();
    }
}