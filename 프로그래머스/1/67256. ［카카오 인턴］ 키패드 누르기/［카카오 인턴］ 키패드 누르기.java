class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10; 
        int right = 12;

        for (int num : numbers) {
            if (num == 0) num = 11;

            if (num % 3 == 1) {
                sb.append("L");
                left = num;
            } else if (num % 3 == 0) {
                sb.append("R");
                right = num;
            } else {
                int leftDist = getDistance(left, num);
                int rightDist = getDistance(right, num);

                if (leftDist < rightDist || (leftDist == rightDist && hand.equals("left"))) {
                    sb.append("L");
                    left = num;
                } else {
                    sb.append("R");
                    right = num;
                }
            }
        }

        return sb.toString();
    }

    private int getDistance(int from, int to) {
        int fromX = (from - 1) / 3, fromY = (from - 1) % 3;
        int toX = (to - 1) / 3, toY = (to - 1) % 3;
        return Math.abs(fromX - toX) + Math.abs(fromY - toY);
    }
}