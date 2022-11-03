package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_08958_Score {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int count = 0;
		int result = 0;

		for (int i = 0; i < a; i++) {
			String str = br.readLine();
			char[] arr = str.toCharArray();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == 'O') {
					count++;
					result += count;
				} else if (arr[j] == 'X') {
					count = 0;
				}
			}
			System.out.println(result);
			result = 0;
			count = 0;
		}

	}

}
