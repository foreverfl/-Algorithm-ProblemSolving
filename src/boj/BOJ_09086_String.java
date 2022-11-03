package boj;
import java.util.Scanner;

public class BOJ_09086_String {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] arr = new String[T];
		char first;
		char last;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
			StringBuilder sb = new StringBuilder(arr[i]);
			char[] temp_first = arr[i].toCharArray();
			first = temp_first[0];
			String reversed = sb.reverse().toString();

			char[] temp_last = reversed.toCharArray();
			last = temp_last[0];

			System.out.println(first + "" + last);

		}
	}

}
