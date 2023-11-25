package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solving_7940_JackAndMagicTree {
    public static final int MAX_HEIGHT = 500;
    public static boolean visited[] = new boolean[501];

    public static class Day {
        int day, prevHeight, nowHeight;

        Day(int day, int prevHeight, int nowHeight) {
            this.day = day;
            this.prevHeight = prevHeight;
            this.nowHeight = nowHeight;
        }

        public String toString() {
            return "[" + day + "] " + prevHeight + " / " + nowHeight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Day> days = calculateTreeGrowth();

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            // sb.append(findMinDays(days, N)).append('\n');
        }

        System.out.println(sb.toString().trim());
    }

    public static List<Day> calculateTreeGrowth() {
        List<Day> days = new ArrayList<>();
        days.add(new Day(1, 0, 1)); // 첫째 날
        int day = 1;

        while (true) {
            day++;
            Day prevDay = days.get(day - 2);
            int nowHeightSunny = prevDay.nowHeight + prevDay.prevHeight;
            int nowHeightCloudy = Math.max(prevDay.nowHeight - 1, 1);
            int nowHeightRainy = (prevDay.nowHeight + prevDay.prevHeight) / 2;

            int nowHeight = Math.min(Math.min(nowHeightSunny, nowHeightCloudy), nowHeightRainy);
            days.add(new Day(day, prevDay.nowHeight, nowHeight));

            if (allHeightsCovered(days)) {
                break;
            }
        }

        return days;
    }

    public static boolean allHeightsCovered(List<Day> days) {
        boolean[] covered = new boolean[MAX_HEIGHT + 1];
        for (Day day : days) {
            if (day.nowHeight <= MAX_HEIGHT) {
                covered[day.nowHeight] = true;
            }
        }

        for (int height = 1; height <= MAX_HEIGHT; height++) {
            if (!covered[height]) {
                return false;
            }
        }
        return true;
    }

}
