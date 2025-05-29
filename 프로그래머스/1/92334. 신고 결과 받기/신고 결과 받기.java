import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 중복 신고 방지를 위한 set
        Set<String> set = new HashSet<>(Arrays.asList(report));
        
        // map 선언
        Map<String, Integer> count = new HashMap<>();
        Map<String, List<String>> reportWho = new HashMap<>();
        
        // map에 값 넣기
        for(String s : set) {
            String[] content = s.split(" ");
            String from = content[0];
            String to = content[1];
            
            // count값 넣기
            count.put(to, count.getOrDefault(to, 0) + 1);
            
            // 신고한 사람의 신고 리스트 넣기
            // 만약 이전에 신고한 적이 없으면 기본값 넣기
            if(!reportWho.containsKey(from))
                reportWho.put(from, new ArrayList<>());
            reportWho.get(from).add(to);
        }
        
        // 신고한 사람 기준으로 신고당한 사람의 신고횟수가 k 이상일 경우 answer에 추가
        for(int i = 0; i < id_list.length; i++) {
            // 신고한 사람
            String reporter = id_list[i];
            
            for(String reportee : reportWho.getOrDefault(reporter, new ArrayList<>())) {
                if(count.get(reportee) >= k)
                    answer[i] += 1;
            }
        }
        
        return answer;
    }
}