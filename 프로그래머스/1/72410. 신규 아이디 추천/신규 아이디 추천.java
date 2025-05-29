import java.io.*;
import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        
        String step1 = new_id.toLowerCase();
        
        for(char c : step1.toCharArray()) {
            if(Character.isAlphabetic((int)c) ||
               Character.isDigit(c) ||
               List.of('-', '_', '.').contains(c)
              ) {
                sb.append(c);
            }
        }
        String step2 = sb.toString();
        
        String step3 = step2;
        while(step3.contains("..")) {
            step3 = step3.replace("..", ".");
        }
        
        String step4 = step3;
        if(step4.startsWith("."))
            step4 = step4.substring(1);
        if(step4.endsWith("."))
            step4 = step4.substring(0, step4.length() - 1);
        
        String step5 = step4;
        if(step5.isEmpty())
            step5 = "a";
        
        String step6 = step5;
        if(step6.length() >= 16)
            step6 = step6.substring(0, 15);
        if(step6.endsWith("."))
            step6 = step6.substring(0, step6.length() - 1);
         
        String step7 = step6;
        while(step7.length() <= 2) {
            step7 += step7.charAt(step7.length() - 1);
        }
        
        return step7;
    }
}