import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 정렬 (작업 요청 시각 빠른 순)
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        
        // 우선순위큐 (작업 소요 시간 적은 순)
        Queue<int[]> pq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);
        
        int curTime = 0;
        int totalResponseTime = 0;
        int jobIndex = 0;
        int completedJobs = 0;
        
        while(completedJobs < jobs.length) {
            // 지금 작업 가능한 작업부터 pq에 넣기
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= curTime) {
                pq.add(jobs[jobIndex]);
                jobIndex++;
            }
            
            // 소요시간 가장 적은 작업부터 시작
            if(!pq.isEmpty()) {
                int[] curJob = pq.poll();
                curTime += curJob[1];
                totalResponseTime += curTime - curJob[0];
                completedJobs++;
            } else {
                curTime = jobs[jobIndex][0];
            }
        }
        
        return totalResponseTime / jobs.length;
    }
}