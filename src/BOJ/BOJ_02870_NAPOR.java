package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_02870_NAPOR {

	static List<BigInteger> numbers = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
			findNumber(arr[i]);
		}

		Collections.sort(numbers);



		for (int i = 0; i < numbers.size(); i++) {
			sb.append(numbers.get(i)).append('\n');
		}

		System.out.println(sb.toString());
	}

	private static void findNumber(String str) {
		String tmp = "";
		for (int i = 0; i < str.length(); i++) {
			if (checkNumber(str.charAt(i))) {
				tmp += (str.charAt(i) - '0');
			} else {
				if (!tmp.equals("")) {
					numbers.add(new BigInteger(tmp));
					tmp = "";
				}
			}
		}

		if (!tmp.equals(""))
			numbers.add(new BigInteger(tmp));
	}

	private static boolean checkNumber(char cha) {
		if (cha - '0' >= 0 && cha - '0' <= 9)
			return true;
		else
			return false;
	}

}
