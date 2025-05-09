import java.util.*;

class Solution {
    Set<String> result = new HashSet<>();
    boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        dfs(user_id, banned_id, 0, new ArrayList<>());
        return result.size();
    }

    void dfs(String[] user_id, String[] banned_id, int depth, List<String> current) {
        if (depth == banned_id.length) {
            List<String> sorted = new ArrayList<>(current);
            Collections.sort(sorted);
            result.add(String.join(",", sorted));
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && isMatch(user_id[i], banned_id[depth])) {
                visited[i] = true;
                current.add(user_id[i]);
                dfs(user_id, banned_id, depth + 1, current);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }

    boolean isMatch(String user, String banned) {
        if (user.length() != banned.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) return false;
        }
        return true;
    }
}