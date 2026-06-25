import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);

        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];

            for (int r = 0; r <= park.length - size; r++) {
                for (int c = 0; c <= park[0].length - size; c++) {
                    if (canPlace(park, r, c, size)) {
                        return size;
                    }
                }
            }
        }

        return -1;
    }

    private boolean canPlace(String[][] park, int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }

        return true;
    }
}