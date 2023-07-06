package programmers_Copied;

public class Copied_Programmers_72414_InsertingAd {
    public static void main(String[] args) {
        System.out.println(solution("02:03:55", "00:14:15", new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        int playTime = convertToSeconds(play_time);
        int advTime = convertToSeconds(adv_time);

        long[] playCount = new long[playTime + 1];
        for (String log : logs) {
            String[] logTime = log.split("-");
            int startTime = convertToSeconds(logTime[0]);
            int endTime = convertToSeconds(logTime[1]);
            playCount[startTime]++;
            playCount[endTime]--;
        }

        // 시간별 재생되는 동영상 개수
        for (int i = 1; i <= playTime; i++) {
            playCount[i] += playCount[i - 1];
        }
        
        // 공익광고 재생시간에 해당하는 구간의 누적 재생시간
        for (int i = 1; i <= playTime; i++) {
            playCount[i] += playCount[i - 1];
        }

        long maxCount = playCount[advTime - 1];
        int startTime = 0;

        for (int i = 0; i + advTime <= playTime; i++) {
            long count = playCount[i + advTime] - playCount[i];
            if (count > maxCount) {
                maxCount = count;
                startTime = i + 1;
            }
        }

        return convertToTimeString(startTime);
    }

    private static int convertToSeconds(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    private static String convertToTimeString(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }
}
