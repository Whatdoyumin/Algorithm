import java.util.*;

class Solution {
    public int solution(String dirs) {
        int r = 0, c = 0;
        Set<String> visited = new HashSet<>();
        
        for(char dir : dirs.toCharArray()) {
            int nr = r, nc = c;
            
            if(dir == 'U') {
                nr++;
            } else if(dir == 'D') {
                nr--;
            } else if(dir == 'R') {
                nc++;
            } else {
                nc--;
            }
            
            if(!isValid(nr, nc)) 
                continue;
            
            String path = r + "," + c + "->" + nr + "," + nc;
            String reverse = nr + "," + nc + "->" + r + "," + c;

            visited.add(path);
            visited.add(reverse);
            
            r = nr;
            c = nc;
        }
        
        return visited.size() / 2;
    }
    
    boolean isValid(int r, int c) {
        return (r <= 5 && r >= -5) && (c <= 5 && c >= -5);
    }
}