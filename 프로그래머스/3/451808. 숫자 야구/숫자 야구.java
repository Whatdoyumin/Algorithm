import java.util.function.Function;
import java.util.*;

class Solution {
    public int solution(int n, Function<Integer, String> submit) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1000; i <= 9999; i++){
            String s = String.valueOf(i);
            
            Set<Character> set = new HashSet<>();
            for(char c : s.toCharArray()) {
                set.add(c);
            }
            
            if (set.size() == 4 && !s.contains("0")) {
                list.add(i);
            }
        }
        
        while(list.size() > 1 && n-- > 0) {
            int num = list.get(0);
            String result = submit.apply(num);
            
            String[] arr = result.split(" ");
            int s = Integer.parseInt(arr[0].substring(0, arr[0].length() - 1));
            int b = Integer.parseInt(arr[1].substring(0, arr[1].length() - 1));
            
            List<Integer> nextList = new ArrayList<>();
            
            for(int i = 0; i < list.size(); i++) {
                int candidate = list.get(i);
                
                int[] result2 = compare(num, candidate);
                int strike = result2[0];
                int ball = result2[1];
                
                if(strike == s && ball == b) {
                    nextList.add(candidate);
                }
            }
                
            list = nextList;
        }
        
        return list.get(0);
    }
    
    public int[] compare(int n1, int n2) {
        int strike = 0;
        String num1 = String.valueOf(n1);
        String num2 = String.valueOf(n2);
        
        for(int i = 0; i < 4; i++) {
            if (num1.substring(i, i+1).equals(num2.substring(i, i+ 1))) {
                strike++;
            }
        }
        
        int total = 0;
        for(int i = 0; i < 4; i++) {
            if (num2.contains(num1.substring(i, i+1)))
                total++;
        }
        int ball = total - strike;
        
        return new int[]{strike, ball};
    }
}

// if (submit.apply(i).equals("4S 0B")) return i;