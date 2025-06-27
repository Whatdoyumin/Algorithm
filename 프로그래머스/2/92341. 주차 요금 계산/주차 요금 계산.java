import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            String[] hm = parts[0].split(":");
            int time = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
            String car = parts[1];
            String status = parts[2];

            if (status.equals("IN")) {
                inTime.put(car, time);
            } else {
                int parked = time - inTime.remove(car);
                totalTime.put(car, totalTime.getOrDefault(car, 0) + parked);
            }
        }

        for (String car : inTime.keySet()) {
            int parked = (23 * 60 + 59) - inTime.get(car);
            totalTime.put(car, totalTime.getOrDefault(car, 0) + parked);
        }

        List<String> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);

        int[] result = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            int time = totalTime.get(cars.get(i));
            if (time <= fees[0]) {
                result[i] = fees[1];
            } else {
                result[i] = fees[1] + 
                    (int) Math.ceil((time - fees[0]) / (double) fees[2]) * fees[3];
            }
        }

        return result;
    }
}