import java.util.*;

class Solution {
    class Word {
        String word;
        int count;
        
        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    private int getDiffCount(String word1, String word2) {
        int count = 0;
        for(int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i))
                count++;
        }
        
        return count;
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));
        
        boolean[] visited = new boolean[words.length];
        
        while(!q.isEmpty()) {
            Word cur = q.poll();
            String curWord = cur.word;
            int count = cur.count;
            
            if(curWord.equals(target)) return count;
            
            for(int i = 0; i < words.length; i++) {
                String nextWord = words[i];
                
                if(getDiffCount(curWord, nextWord) == 1) {
                    if(!visited[i]) {
                        q.offer(new Word(nextWord, count + 1));
                        visited[i] = true;
                    }
                }
                
            }
        }
        
        
        return 0;
    }
    
    
}