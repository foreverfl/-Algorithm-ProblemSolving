package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01924_2007 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int day = 0;
		int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 1; i < x; i++) {
			day += months[i];
		}

		day = day + y;

		String ans = calculateDay(day);

		System.out.println(ans);
	}

	private static String calculateDay(int num) {
		if (num % 7 == 1)
			return "MON";
		else if (num % 7 == 2)
			return "TUE";
		else if (num % 7 == 3)
			return "WED";
		else if (num % 7 == 4)
			return "THU";
		else if (num % 7 == 5)
			return "FRI";
		else if (num % 7 == 6)
			return "SAT";
		else if (num % 7 == 0)
			return "SUN";

		return null;
	}

}
