package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_01440_TimeMachine {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] arr_str = input.split(":");
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			list.add(Integer.parseInt(arr_str[i]));
		}

		int cnt = 0;
		for (int i = 0; i < 3; i++) {

			ArrayList<Integer> tmp_1 = (ArrayList<Integer>) list.clone();

			if (checkHour(list.get(i))) {
				tmp_1.remove(i);

				for (int j = 0; j < 2; j++) {

					ArrayList<Integer> tmp_2 = (ArrayList<Integer>) tmp_1.clone();

					if (checkMinuteAndSecond(tmp_1.get(j))) {

						tmp_2.remove(j);

						if (checkMinuteAndSecond(tmp_2.get(0))) {
							cnt++;
						}
					}

				}

			}
		}

		System.out.println(cnt);

	}

	private static boolean checkHour(int input) {
		if (input >= 1 && input <= 12) {
			return true;
		}
		return false;
	}

	private static boolean checkMinuteAndSecond(int input) {
		if (input >= 0 && input <= 59) {
			return true;
		}
		return false;
	}

}
