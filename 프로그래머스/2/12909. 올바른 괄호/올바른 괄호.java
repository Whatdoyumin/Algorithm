import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') 
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (top != '(' && c == ')')
                    return false;
            }
        }
        
        return stack.isEmpty();
    }
}