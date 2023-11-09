package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _7870_ThreeColorInk {
    public static void main(String[] args) throws IOException {

        // 각 달의 마지막 일
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // 요일을 배열 인덱스로 변환하기 위한 맵
        Map<String, Integer> dayIndexMap = new HashMap<>();
        dayIndexMap.put("SUN", 0);
        dayIndexMap.put("MON", 1);
        dayIndexMap.put("TUE", 2);
        dayIndexMap.put("WED", 3);
        dayIndexMap.put("THU", 4);
        dayIndexMap.put("FRI", 5);
        dayIndexMap.put("SAT", 6);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String startDay = br.readLine();
        int N = Integer.parseInt(br.readLine());
        List<LocalDate> holidays = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            holidays.add(LocalDate.of(2023, Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        int[][] counts = new int[10][3];

        int currentDayOfWeek = dayIndexMap.get(startDay);
        for (int month = 0; month < 12; month++) {
            for (int day = 1; day <= daysInMonth[month]; day++) {
                // 해당 날짜가 공휴일인지 확인
                LocalDate currentDate = LocalDate.of(2023, month + 1, day);
                boolean isHoliday = holidays.contains(currentDate);

                int tens = day / 10;
                int ones = day % 10;

                // 빨간색으로 칠하는 경우 (일요일 또는 공휴일)
                if (currentDayOfWeek == 0 || isHoliday) {
                    if (tens != 0) {
                        counts[tens][0]++;
                    }
                    counts[ones][0]++;
                }
                // 파란색으로 칠하는 경우 (토요일)
                else if (currentDayOfWeek == 6) {
                    if (tens != 0) {
                        counts[tens][1]++;
                    }
                    counts[ones][1]++;
                }
                // 검정색으로 칠하는 경우 (평일)
                else {
                    if (tens != 0) {
                        counts[tens][2]++;
                    }
                    counts[ones][2]++;
                }

                currentDayOfWeek = (currentDayOfWeek + 1) % 7; // 다음 날짜로 요일 업데이트
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(counts[i][0] + " " + counts[i][1] + " " + counts[i][2]);
        }
    }
}
