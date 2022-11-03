package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02408_TwentyFour {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String current = br.readLine();
		String mission = br.readLine();

		String[] current_tmp = current.split(":");
		String[] mission_tmp = mission.split(":");

		int[] current_arr = new int[3];
		int[] mission_arr = new int[3];

		for (int i = 0; i < 3; i++) {
			current_arr[i] = Integer.parseInt(current_tmp[i]);
			mission_arr[i] = Integer.parseInt(mission_tmp[i]);
		}

		int sec = 0;
		while (true) {

			current_arr[2]++;
			sec++;

			if (current_arr[2] == 60) {
				current_arr[2] = 0;
				current_arr[1]++;
			}

			if (current_arr[1] == 60) {
				current_arr[1] = 0;
				current_arr[0]++;
			}

			if (current_arr[0] == 24) {
				current_arr[0] = 0;
			}

			if (current_arr[0] == mission_arr[0] && current_arr[1] == mission_arr[1]
					&& current_arr[2] == mission_arr[2])
				break;
		}

		int hour = sec / 3600;
		sec = sec % 3600;

		int minute = sec / 60;
		int second = sec % 60;

		String hour_result = Integer.toString(hour);
		String minute_result = Integer.toString(minute);
		String second_result = Integer.toString(second);

		String a = addZero(hour_result);
		String b = addZero(minute_result);
		String c = addZero(second_result);

		System.out.print(a + ":" + b + ":" + c);

	}

	private static String addZero(String input) {
		while (input.length() != 2) {
			input = "0" + input;
		}
		return input;
	}

}
