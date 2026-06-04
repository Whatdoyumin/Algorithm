class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {

            int limit = getLimitTime(schedules[i]);
            boolean success = true;

            for (int j = 0; j < 7; j++) {

                int day = (startday + j - 1) % 7 + 1;

                // 토요일, 일요일은 제외
                if (day == 6 || day == 7) {
                    continue;
                }

                if (timelogs[i][j] > limit) {
                    success = false;
                    break;
                }
            }

            if (success) {
                answer++;
            }
        }

        return answer;
    }

    private int getLimitTime(int time) {
        int hour = time / 100;
        int min = time % 100;

        min += 10;

        if (min >= 60) {
            hour++;
            min -= 60;
        }

        return hour * 100 + min;
    }
}