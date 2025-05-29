import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(isCorrect(s))
                count++;
            
            s = s.substring(1) + s.charAt(0);
        }
        
        return count;
    }
    
    boolean isCorrect(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                
                char top = stack.pop();
                
                if(top != '(' && c == ')') return false;
                if(top != '{' && c == '}') return false;
                if(top != '[' && c == ']') return false;
            }
        }
        return stack.isEmpty();
    }
}