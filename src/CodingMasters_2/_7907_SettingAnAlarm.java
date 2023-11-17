package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class _7907_SettingAnAlarm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String time = br.readLine();
        int N = Integer.parseInt(br.readLine());

        LocalTime alarmTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));

        LocalTime finalAlarmTime = calculateAlarmTime(alarmTime, N);

        // 결과 출력
        System.out.println(finalAlarmTime.format(DateTimeFormatter.ofPattern("HH:mm")));
    }

    public static LocalTime calculateAlarmTime(LocalTime initialTime, int N) {
        long totalMinutesToAdd = (long) N * (N - 1) / 2;

        return initialTime.plusMinutes(totalMinutesToAdd);
    }
}
