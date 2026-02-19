import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 자카드 유사도 J(A, B)
        // 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값
        // 두 집합 모두 공집합일 경우 J(A, B) = 1
        
        // 문자열 사이의 유사도
        // 두 글자씩 끊어서 다중집합을 만들고, (교집합 크기) / (합집합 크기)
        // 영문자만 유효, 기타 공백/숫자/특수 문자는 그 쌍을 버림
        // *대문자 소문자 차이 무시
        
        // 출력 : 값 * 65536 (소수점 아래 버리고 정수만)
        
        int answer = 65536;
        int length1 = str1.length();
        str1 = str1.toLowerCase();
        // 각 2글자의 횟수
        Map<String, Integer> map1 = insertMap(str1);
        
        int length2 = str2.length();
        str2 = str2.toLowerCase();
        Map<String, Integer> map2 = insertMap(str2);
        
        // map1.forEach((key, value) -> {
        //     System.out.println(key + ", " + value);
        // });
        // System.out.println();
        // map2.forEach((key, value) -> {
        //     System.out.println(key + ", " + value);
        // });
        
        // 교집합 구하기
        int a = 0;
        for(String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                a += Math.min(map1.get(key), map2.get(key));
            }
        }
        
        // 합집합 구하기
        int b = 0;
        for(int v : map1.values()) {
            b += v;
        }
        for(int v : map2.values()) {
            b += v;
        }
        b -= a;
        
        if (b == 0) return answer;
        else answer *= (double) a / b;
        
        return answer;
    }
    
    public Map<String, Integer> insertMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            
            if (isValid(c1) && isValid(c2)) {
                String now = str.substring(i, i + 2);
                int count = map.getOrDefault(now, 0);
                
                map.put(now, count + 1);
            }
        }
        
        return map;
    }
    
    // 알파벳 문자 여부
    public boolean isValid(Character c) {
        return c >= 'a' && c <= 'z';
    }
}