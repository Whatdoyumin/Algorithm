import java.util.*;

class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        dfs(new ArrayList<>(), nums);
        return answer;
    }

    void dfs(List<Integer> temp, int[] nums) {
        if(temp.size() == nums.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                dfs(temp, nums);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}