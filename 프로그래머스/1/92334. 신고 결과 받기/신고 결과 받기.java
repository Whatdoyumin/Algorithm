import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 중복 없애기 위해 set 선언
        Set<String> set = new HashSet<>(Arrays.asList(report));
        
        // 신고횟수 저장
        Map<String, Integer> count = new HashMap<>();
        Map<String, List<String>> reportWho = new HashMap<>();
        
        for(String r : set) {
            String[] fromTo = r.split(" ");
            String from = fromTo[0];
            String to = fromTo[1];
            
            count.put(to, count.getOrDefault(to, 0) + 1);
            
            // 신고 한 번도 안 한 사람이면 추가
            if(!reportWho.containsKey(from))
                reportWho.put(from, new ArrayList<>());
            
            reportWho.get(from).add(to);
            
        }
        
        
        // k보다 신고 많이 받은 사람 찾기
        for(int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i];
            
            for(String reportee : reportWho.getOrDefault(reporter, new ArrayList<>())) {
                if(count.get(reportee) >= k) 
                    answer[i] += 1;
            }
        }
        
        return answer;
    }
}