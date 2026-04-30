class Solution {
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        int answer = 0;

        boolean[] visited = new boolean[length];

        int[] min = new int[length];
        min[0] = 0;
        for(int i = 1; i < length; i++) min[i] = Integer.MAX_VALUE;

        for(int i = 0; i < length; i++) {
            int minIndex = -1;
            for(int j = 0; j < length; j++) {
                if(!visited[j] && (minIndex == -1 || min[j] < min[minIndex])) {
                    minIndex = j;
                }
            }

            visited[minIndex] = true;
            answer += min[minIndex];

            for(int j = 0; j < length; j++) {
                int cost = Math.abs(points[minIndex][0] - points[j][0]) + Math.abs(points[minIndex][1] - points[j][1]);
                
                if(!visited[j]) min[j] = Math.min(min[j], cost);
            }
        }

        return answer;
    }
}