package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02525_OvenClock {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		int cooked_time = Integer.parseInt(br.readLine());

		int cooked_hour = cooked_time / 60;
		int cooked_minute = cooked_time % 60;

		hour = hour + cooked_hour;
		minute = minute + cooked_minute;

		if (minute >= 60) {
			hour = hour + 1;
			minute = minute - 60;
		}
		if (hour >= 24) {
			hour = hour - 24;
		}

		System.out.println(hour + " " + minute);
	}

}
