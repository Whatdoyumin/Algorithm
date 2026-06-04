class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] arr = new int[numCourses];

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            int course = pre[0];
            int before = pre[1];

            graph.get(before).add(course);
            arr[course]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (arr[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            count++;

            for (int next : graph.get(current)) {
                arr[next]--;

                if (arr[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return count == numCourses;
    }
}