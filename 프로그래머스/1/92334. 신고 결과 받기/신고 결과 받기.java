import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, HashSet<String>> reporter = new HashMap<>();
        Map<String, Integer> reportee = new HashMap<>();
        HashSet<String> set;
        
        for(String name : id_list) {
            reporter.put(name, new HashSet<>());
            reportee.put(name, 0);
        }
        
        for(String r : report) {
            StringTokenizer st = new StringTokenizer(r);
            String from = st.nextToken();
            String to = st.nextToken();
            
            set = reporter.get(from);
            if(set.add(to)) {
                reportee.put(to, reportee.get(to) + 1);
            }
        }
        
        for(int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            
            set = reporter.get(name);
            for(String s : set) {
                if (reportee.get(s) >= k) {
                    answer[i] += 1;
                }
            }
        }
        
        return answer;
    }
}