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
    
    int getDiffCount(String word1, String word2) {
        int count = 0;
        for(int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) count++;
        }
        
        return count;
    }
    
    public int solution(String begin, String target, String[] words) {
        // bfs로 최단 거리 구하기
        // 시작점 예약 ()
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));
        
        boolean[] visited = new boolean[words.length];
        
        while(!q.isEmpty()) {
            // 현재 노드 방문
            Word cur = q.poll();
            
            // if 현재노드 == target : return count;
            if(cur.word.equals(target)) return cur.count;
            
            // 다음 노드 방문
            for(int i = 0; i < words.length; i++) {
                String next = words[i];
                if(getDiffCount(cur.word, next) == 1) {
                    if(!visited[i]) {
                        q.offer(new Word(next, cur.count+1));
                        visited[i] = true;
                    }
                }
            }
        }
        
        return 0;
    }
}