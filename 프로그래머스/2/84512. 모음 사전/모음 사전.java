class Solution {
    static String[] words = {"A", "E", "I", "O", "U"};
    static boolean found = false;
    static int count = 0;
    
    public int solution(String word) {
        dfs("", word);
        return count;
    }
    
    private void dfs(String cur, String target) {
        if (found) return;
        
        if (!cur.isEmpty()) {
            count++;
            
            if (cur.equals(target)) {
                found = true;
                return;
            }
        }
        
        if (cur.length() == 5) return;
        
        for(String w : words)
            dfs(cur + w, target);
    }
}