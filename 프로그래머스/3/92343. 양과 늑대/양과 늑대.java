import java.util.*;

class Solution {
    Map<Integer, List<Integer>> tree = new HashMap<>();
    int answer = 0;

    public int solution(int[] info, int[][] edges) {
        for (int i = 0; i < info.length; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }

        // 시작 노드
        List<Integer> start = new ArrayList<>();
        start.add(0);

        // 양, 늑대, 현재 노드, info
        dfs(0, 0, start, info);

        return answer;
    }

    private void dfs(int sheep, int wolf, List<Integer> start, int[] info) {
        for (int i = 0; i < start.size(); i++) {
            int cur = start.get(i);
            int newSheep = sheep;
            int newWolf = wolf;

            if (info[cur] == 0) newSheep++;
            else newWolf++;

            if (newWolf >= newSheep) continue;

            answer = Math.max(answer, newSheep);

            List<Integer> next = new ArrayList<>(start);
            next.remove(i);
            if (tree.containsKey(cur)) {
                next.addAll(tree.get(cur));
            }

            dfs(newSheep, newWolf, next, info);
        }
    }
}