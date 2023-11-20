package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class _7931_ElectronicWatch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LocalTime t = LocalTime.parse(br.readLine(), DateTimeFormatter.ofPattern("HH:mm"));
        int k = Integer.parseInt(br.readLine());

        LocalTime now = t;
        List<LocalTime> times = new ArrayList<>();
        times.add(now);
        while (true) {
            now = now.plusMinutes(k);
            if (times.contains(now))
                break;

            times.add(now);
        }

        int res = 0;
        for (LocalTime time : times) {
            if (isPalindromicTime(time))
                res++;
        }

        System.out.println(res);
    }

    public static boolean isPalindromicTime(LocalTime time) {
        String hours = String.format("%02d", time.getHour());
        String minutes = String.format("%02d", time.getMinute());

        // Reverse the minutes and compare with hours
        String reversedMinutes = new StringBuilder(minutes).reverse().toString();

        return hours.equals(reversedMinutes);
    }
}
