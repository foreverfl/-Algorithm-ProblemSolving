package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2562_Maximum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer arr[] = new Integer[9];
		int max = -1;
		int check = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);

			if (arr[i] == max) {
				check = i+1;
			}
		}

		System.out.println(max);
		System.out.println(check);
	}

}
