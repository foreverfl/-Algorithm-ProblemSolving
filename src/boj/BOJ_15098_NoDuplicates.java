package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15098_NoDuplicates {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");

		boolean isDuplicated = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j)
					continue;

				if (arr[i].equals(arr[j])) {
					isDuplicated = true;
					break;
				}
			}
		}

		if (isDuplicated)
			System.out.println("no");
		else
			System.out.println("yes");
	}

}
