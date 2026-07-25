import java.util.*;

class Solution {
    static List<List<int[]>> requestsByType;
    static int[][] wait;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int k, int n, int[][] reqs) {
        // k = 상담 유형 개수
        // n = 멘토 수
        // int[] r : reqs = 요청 시작 분, 소요 분, 유형
        
        // 1) 멘토는 상담 유형 하나만 담당 (다른 유형 상담 X)
        // 2) 멘토는 동시에 참가자 한 명과만 상담 (참가자가 요청한 시간만큼)
        
        // 요청 유형이 많은 순으로 멘토 배치? X
        // 우선순위큐 사용 ? 
        // 분배해야하는 인원 = n - k
        
        // 1. 먼저 유형별 대기 시간을 계산
        // 상담 유형별 요청 목록
        requestsByType = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            requestsByType.add(new ArrayList<>());
        }
        
        // 요청을 유형별로 넣기
        for(int[] req : reqs) {
            int type = req[2] - 1;
            requestsByType.get(type).add(req);
        }
        
        // 각 상담 유형마다 멘토가 1명, 2명, ... 일 때의 총 대기시간 계산
        // wait[type][mentorCount]
        wait = new int[k][n + 1];
        
        // 각 유형별로 멘토 수를 변경하며 대기 시간 계산
        for(int type = 0; type < k; type++) {
            for(int mentorCount = 1; mentorCount <= n; mentorCount++) {
                // 한 유형의 각 멘토의 상담 종료 시간
                PriorityQueue<Integer> endTime = new PriorityQueue<>();
                // 멘토 수만큼 초기 종료 시간 0
                for(int i = 0; i < mentorCount; i++) endTime.add(0);
                
                // 1번(0) 타입이 1명일때, 2명일때, 3명일때 ....
                // 계산하려면 1번이 1명이면
                //      -> 10 시작 70 끝, 대기 0
                //      -> 70 시작 100 끝, 대기 50 (70 - 20)
                //      -> 100 시작 140 끝, 대기 50 (100 - 50)
                //      -> 140 시작 170 끝, 대기 75 (140 - 65)
                //      => wait[0][1] = 0 + 50 + 50 + 75 = 175
                // 1번이 2명이면
                //      -> (1) 10 시작 70 끝, 대기 0
                //      -> (2) 20 시작 50 끝, 대기 0
                //      -> (2) 50 시작 90 끝, 대기 0
                //      -> (1) 70 시작 100 끝, 대기 5 (70 - 65)
                //      => wait[0][2] = 0 + ... + 5 = 5
                
                
                // requestByType[type]의 요청을 순서대로 처리
                for(int[] req : requestsByType.get(type)) {
                    int mentorEndTime = endTime.poll();
                
                    int startTime = Math.max(mentorEndTime, req[0]);
                    int waitingTime = startTime - req[0];
                    int newEndTime = startTime + req[1];
                    
                    endTime.offer(newEndTime);
                    wait[type][mentorCount] += waitingTime;
                }
            }
        }
        
        // 2. 전체 멘토를 각 유형에 배분
        // DFS로 각 유형에 멘토 몇 명 배정할지 정하기
        // dfs(type, 지금까지 배정한 멘토 수, 지금까지 선택한 유형들의 대기합)
        
        dfs(0, 0, 0);
        
        return answer;
    }
    
    private void dfs(int type, int curMentors, int curWait) {
        int k = wait.length;
        int n = wait[0].length - 1;
        int totalWait = 0;
        
        if (curMentors == n) {
            answer = Math.min(answer, curWait);
        }
        
        if (type == k) return;
        
        // 0번 유형에 1명 배정
        //      1번 유형에 1명 배정
        //          2번 유형에 3명 배정
        // 0번 유형에 1명 배정
        //      1번 유형에 2명 배정
        //          2번 유형에 2명 배정
        
        // 배정 끝나면 다시 상담 시작이 아니라 이미 계산한 wait 저장
        
        for (int mentorCount = 1; mentorCount <= n - curMentors - (k - type - 1); mentorCount++) {
            dfs(type + 1, curMentors + mentorCount, curWait + wait[type][mentorCount]);
        }
    }
}