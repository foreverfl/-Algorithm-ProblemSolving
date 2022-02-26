package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01267_PhoneBill {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int sum_young = 0;
		int sum_min = 0;
		st = new StringTokenizer(br.readLine());
		while (N-- > 0) {
			int input = Integer.parseInt(st.nextToken());

			sum_young += young(input);
			sum_min += min(input);
		}

		if (sum_young < sum_min)
			System.out.println("Y " + sum_young);
		else if (sum_young > sum_min)
			System.out.println("M " + sum_min);
		else
			System.out.println("Y M " + sum_young);
	}

	private static int young(int input) {
		int result = ((input / 30) + 1) * 10;
		return result;
	}

	private static int min(int input) {
		int result = ((input / 60) + 1) * 15;
		return result;
	}

}
