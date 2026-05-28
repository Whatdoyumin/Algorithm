import java.util.*;

class Solution {
    // 프로그래머스 42890 후보키
    
    // 모든 조합 저장
    List<Set<Integer>> combinations = new ArrayList<>();
    
    public int solution(String[][] relation) {
        // relation: 학번, 이름, 전공, 학년
        int colSize = relation[0].length;
        
        // 조합 생성
        for (int size = 1; size <= colSize; size++) {
            comb(new HashSet<>(), 0, size, colSize);
        }
        List<Set<Integer>> candidates = new ArrayList<>();

        // 후보키 검사
        for (Set<Integer> comb : combinations) {
            // 유일성 검사, 최소성 검사
            if (checkUnique(comb, relation) && checkMin(comb, candidates)) {
                candidates.add(comb);
            }
        }

        return candidates.size();
    }

    private void comb(Set<Integer> current, int start, int r, int n) {

        if (current.size() == r) {
            combinations.add(new HashSet<>(current));
            return;
        }

        for (int i = start; i < n; i++) {
            current.add(i);
            comb(current, i + 1, r, n);
            current.remove(i);
        }
    }

    private boolean checkUnique(Set<Integer> cols, String[][] relation) {
        Set<String> rowSet = new HashSet<>();

        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();

            for (int col : cols) {
                sb.append(row[col]);
            }
            rowSet.add(sb.toString());
        }
        return rowSet.size() == relation.length;
    }

    private boolean checkMin(Set<Integer> cand, List<Set<Integer>> candKeys) {
        for (Set<Integer> key : candKeys) {
            if (cand.containsAll(key)) {
                return false;
            }
        }

        return true;
    }
}