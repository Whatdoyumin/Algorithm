import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub = new Stack<>();
        int idx = 0;
        
        for (int box = 1; box <= order.length; box++) {
            // 메인 벨트에서 박스를 꺼내 바로 처리하지 못하면 보조 컨테이너에 쌓음
            sub.push(box);

            // 보조 컨테이너에서 꺼낸 박스가 순서와 맞는 동안 계속 처리
            while (!sub.isEmpty() && sub.peek() == order[idx]) {
                sub.pop();
                idx++;
                answer++;
            }
        }

        return answer;
    }
}