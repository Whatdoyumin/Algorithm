import java.util.*;

class Solution {
    Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        // 가능한 메뉴 조합을 카운트하고 가장 많이 주문된 조합만 골라 결과에 담기
        
        List<String> result = new ArrayList<>();

        for (int c : course) {
            map = new HashMap<>();

            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                dfs(arr, c, 0, new StringBuilder());
            }

            int max = 0;
            for (int v : map.values()) {
                if (v >= 2 && v > max) {
                    max = v;
                }
            }

            for (String key : map.keySet()) {
                if (map.get(key) == max) {
                    result.add(key);
                }
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    // 조합만들기
    void dfs(char[] arr, int len, int idx, StringBuilder sb) {
        if (sb.length() == len) {
            String comb = sb.toString();
            map.put(comb, map.getOrDefault(comb, 0) + 1);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sb.append(arr[i]);
            dfs(arr, len, i + 1, sb); 
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}