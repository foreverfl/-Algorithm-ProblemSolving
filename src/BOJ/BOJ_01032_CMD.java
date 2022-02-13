package BOJ;

import java.util.Scanner;

public class BOJ_01032_CMD {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] arr = new String[T];

		for (int i = 0; i < T; i++) {
			arr[i] = sc.next();
		}

		char[] check = arr[0].toCharArray();

		for (int i = 1; i < T; i++) {
			for (int j = 0; j < check.length; j++) {

				if (check[j] != (arr[i].charAt(j))) {
					check[j] = '?';
				}
			}
		}

		String[] result_arr = new String[check.length];
		for (int i = 0; i < check.length; i++) {
			result_arr[i] = Character.toString(check[i]);
		}
		String result = String.join("", result_arr);

		System.out.println(result);

	}

}
