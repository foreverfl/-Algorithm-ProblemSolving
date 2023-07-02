package programmers_Copied;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;

public class Copied_Programmers_17678_ShuttleBus {
    public static void main(String[] args) {
        System.out.println(solution(1, 1, 5, new String[] {"08:00", "08:01", "08:02", "08:03"}));
        System.out.println(solution(2, 10, 2, new String[] {"09:10", "09:09", "08:00"}));
        System.out.println(solution(2, 1, 2, new String[] {"09:00", "09:00", "09:00", "09:00"}));
        System.out.println(solution(1, 1, 5, new String[] {"00:01", "00:01", "00:01", "00:01", "00:01"}));
        System.out.println(solution(1, 1, 1, new String[] {"23:59"}));
        System.out.println(solution(10, 60, 45, new String[] {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<LocalTime> pq = new PriorityQueue<>();
        for (String time : timetable) {
            LocalTime person = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
            pq.add(person);
        }

        LocalTime start_time = LocalTime.of(9, 0); // 09:00
        LocalTime last_time = null;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total = 0;
            while (!pq.isEmpty()) {
                LocalTime current_time = pq.peek();
                if (current_time.isBefore(start_time) || current_time.equals(start_time)) {
                    if (total < m) {
                        pq.poll();
                        total++;
                    } else {
                        break;
                    }
                    last_time = current_time.minusMinutes(1);
                } else {
                    break;
                }
            }

            start_time = start_time.plusMinutes(t);
        }

        if (total < m) 
            last_time = start_time.minusMinutes(t);
        

        if (last_time == null) 
            last_time = LocalTime.of(9, 0).plusMinutes((n - 1) * t);
        

        return last_time.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}

// reference: https://moonsbeen.tistory.com/372