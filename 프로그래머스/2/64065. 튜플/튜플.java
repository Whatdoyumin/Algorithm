import java.util.*;

class Solution {
    public int[] solution(String s) {
        // s가 표현하는 튜플을 배열에 담아 return하는 문제
        // s는 숫자와 { } , 로만 이루어져 있다.
        // 중복되는 원소가 없으므로, 숫자만 추출
        Set<Integer> set = new LinkedHashSet<>(); 
        int len = s.length();
        
        String fixed = s.substring(1, len - 1);
        String[] result = fixed.split("\\},\\{");
        
        Arrays.sort(result, (a, b) -> a.length() - b.length());
        
        for(String r : result) {
            r = r.replace("{", "").replace("}", "");
            
            String[] arr = r.split(",");
            for(String a : arr) {
                set.add(Integer.parseInt(a));
            }
        }
        
        int[] answer = new int[set.size()];
        int i = 0;
        
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            answer[i] = it.next();
            i++;
        }
        
        return answer;
    }
}