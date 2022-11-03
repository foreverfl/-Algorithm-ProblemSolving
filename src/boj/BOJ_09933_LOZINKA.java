package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_09933_LOZINKA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		String result = "";
		loop: for (int i = 0; i < N; i++) {
			String tmp = reverse(arr[i]);
			for (int j = 0; j < N; j++) {
				if (tmp.equals(arr[j])) {
					result = tmp;
					break loop;
				}

			}
		}

		System.out.println(result.length() + " " + result.charAt(result.length() / 2));
	}

	private static String reverse(String str) {
		StringBuilder reverse = new StringBuilder();
		reverse.append(str);
		reverse.reverse();
		String result = reverse.toString();
		return result;
	}
}
