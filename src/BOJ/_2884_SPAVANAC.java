package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2884_SPAVANAC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String time = br.readLine();
		String timeString[] = time.split(" ");
		int timeInt[] = new int[2];
		timeInt[0] = Integer.parseInt(timeString[0]);
		timeInt[1] = Integer.parseInt(timeString[1]);
		int hour = 0;
		int minute = 0;

		if (timeInt[1] >= 45) {
			hour = timeInt[0];
			minute = timeInt[1] - 45;
		} else if (timeInt[0] < 45) {
			hour = timeInt[0] - 1;
			minute = timeInt[1] + 60 - 45;
			if (hour < 0) {
				hour = 23;
			}
		}

		System.out.print(hour + " " + minute);

	}

}
