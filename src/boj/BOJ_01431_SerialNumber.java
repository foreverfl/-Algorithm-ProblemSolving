package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_01431_SerialNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(makeSum(arr[i]));
//		}

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					if (makeSum(o1) == makeSum(o2)) {
						return o1.compareTo(o2);
					}

					return makeSum(o1) - makeSum(o2);
				}
				return o1.length() - o2.length();
			}

		});

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	private static int makeSum(String str) {
		int result = 0;

		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);

			if (tmp - '0' >= 0 && tmp - '0' <= 9) {
				result += tmp - '0';
			}
		}

		return result;
	}

}
