import java.util.*;

class Solution {
    private List<String> list = new ArrayList<>();
    private boolean[] used;
    
    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    
    public void dfs(String current, String path, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            list.add(path);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, depth + 1);
                used[i] = false;
            }
        }
    }
}