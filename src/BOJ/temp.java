package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class temp {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] arr = new String[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = br.readLine();
		}

		for (int i = 0; i < 100; i++) {
			System.out.println(arr[i]);
		}

		for (int i = 0; i < 100; i++) {
			sb.append(arr[i]).append('\n');
		}

		System.out.println(sb.toString());

	}
}