package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_23343_JavaScript {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		String[] arr = str.split(" ");
		if (arr.length == 2) {
			boolean isNaN = false;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < arr[i].length(); j++) {
					if (arr[i].charAt(j) < '0' || arr[i].charAt(j) > '9') {
						isNaN = true;
					}
				}
			}

			if (isNaN) {
				sb.append("NaN");
			} else {
				sb.append(Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]));
			}
		} else {
			sb.append("NaN");
		}

		System.out.print(sb.toString());
	}

}
