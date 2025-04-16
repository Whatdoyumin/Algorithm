import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        
        int n = progresses.length;
        int[] days = new int[n];
        
        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            days[i] = (int) Math.ceil((double) remain / speeds[i]);
        }
        
        int deployDay = days[0];
        int count = 1;
        
        for (int i = 1; i < n; i++){
            if (days[i] <= deployDay) {
                count++;
            } else {
                answerList.add(count);
                deployDay = days[i];
                count = 1;
            }
        }
        
        answerList.add(count);
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}