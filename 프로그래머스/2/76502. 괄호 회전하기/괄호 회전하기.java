import java.util.*;

class Solution {
    public int solution(String s) {
        // s를 왼쪽으로 회전시켰을 때 올바른 문자열이 되게 하는 개수
        
        int answer = 0;
        int length = s.length();
        
        // 회전시키고, 올바른지 판단하기
        for(int i = 0; i < length; i++) {
            String cur = s.substring(i, length);
            if(i > 0) cur += s.substring(0, i);
            
            Stack<Character> st = new Stack<>();
            boolean isValid = true;
            
            for(int j = 0; j < length; j++) {
                Character curWord = cur.charAt(j);
                
                if (curWord.equals('(') || curWord.equals('{') || curWord.equals('[')) st.push(curWord);
                
                else {
                    if (st.isEmpty()) {
                        isValid = false;
                        break;
                    };
                    Character top = st.peek();
                    
                    if (top.equals('(') && !curWord.equals(')')) break;
                    if (top.equals('{') && !curWord.equals('}')) break;
                    if (top.equals('[') && !curWord.equals(']')) break;
                    
                    st.pop();
                }
            }
            
            if (isValid && st.isEmpty()) answer++;
        }
        
        return answer;
    }
}