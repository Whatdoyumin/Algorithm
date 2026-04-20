import java.util.*;

class Solution {
    int k;
    int n;
    int[][] reqs;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int k, int n, int[][] reqs) {
        this.k = k;
        this.n = n;
        this.reqs = reqs;
        
        int[] counts = new int[k];
        
        Arrays.fill(counts, 1);
        
        distribute(counts, 0, n - k);
        
        return answer;
    }
    
    void distribute(int[] counts, int type, int remaining) {
        if (type == k - 1) {
            counts[type] = 1 + remaining;
            answer = Math.min(answer, simulate(counts));
            return;
        }
        
        for (int i = 0; i <= remaining; i++) {
            counts[type] = 1 + i;
            distribute(counts, type + 1, remaining - i);
        }
    }
    
    int simulate(int[] counts) {
        int totalWait = 0;
        
        Queue<Integer>[] mentors = new PriorityQueue[k];
        for (int i = 0; i < k; i++) {
            mentors[i] = new PriorityQueue<>();
            for (int j = 0; j < counts[i]; j++) {
                mentors[i].add(0);
            }
        }
        
        for (int[] req : reqs) {
            int time = req[0];
            int duration = req[1];
            int type = req[2] - 1;
            
            Queue<Integer> pq = mentors[type];
            int earliest = pq.poll();
            
            if (earliest <= time) {
                pq.add(time + duration);
            } else {
                totalWait += earliest - time;
                pq.add(earliest + duration);
            }
        }
        
        return totalWait;
    }
}