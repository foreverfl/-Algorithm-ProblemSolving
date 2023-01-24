package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_22428_StepAerobics {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;

			String exercise = br.readLine();
			exercise = exercise.replaceAll("ru lu", "0");
			exercise = exercise.replaceAll("lu ru", "0");
			exercise = exercise.replaceAll("rd ld", "0");
			exercise = exercise.replaceAll("ld rd", "0");

			int cnt = 0;
			for (int i = 0; i < exercise.length(); i++) {
				if (exercise.charAt(i) == '0')
					cnt++;
			}

			sb.append(cnt).append('\n');

		}

		System.out.print(sb.toString());
	}

}
