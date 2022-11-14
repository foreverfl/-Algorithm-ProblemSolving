package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02947_MJEHURIC {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[6];
		for (int i = 1; i <= 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int tmp = 0;
		while (true) {
			if (arr[1] > arr[2]) {
				tmp = arr[2];
				arr[2] = arr[1];
				arr[1] = tmp;
				print(arr);
			}

			if (isEnd(arr))
				break;

			if (arr[2] > arr[3]) {
				tmp = arr[3];
				arr[3] = arr[2];
				arr[2] = tmp;
				print(arr);
			}

			if (isEnd(arr))
				break;

			if (arr[3] > arr[4]) {
				tmp = arr[4];
				arr[4] = arr[3];
				arr[3] = tmp;
				print(arr);
			}

			if (isEnd(arr))
				break;

			if (arr[4] > arr[5]) {
				tmp = arr[5];
				arr[5] = arr[4];
				arr[4] = tmp;
				print(arr);
			}

			if (isEnd(arr))
				break;
		}

		System.out.println(sb.toString());

	}

	private static boolean isEnd(int[] arr) {
		for (int i = 1; i <= 5; i++) {
			if (arr[i] != i) {
				return false;
			}
		}

		return true;
	}

	private static void print(int[] arr) {
		for (int i = 1; i <= 5; i++) {
			sb.append(arr[i] + " ");
		}
		sb.append('\n');

	}

}
