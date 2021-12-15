package BOJ_incomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1110_PlusCycle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int check = input;
		int count = 0;
		while (true) {
			input = answer(input);
			
			count++;
			if (check == input) {
				break;
			}
		}
		System.out.println(count);
	}

	public static int answer(int a) {
		int sum = 0;
		int num1 = 0;
		int num2 = 0;
		int result = 0;

		String str = Integer.toString(a); // string '68'
		if (str.length() == 1) {
			str = "0" + str;
		}
		String arr1[] = str.split(""); // string array {6, 8}
		num1 = Integer.parseInt(arr1[0]); // integer '6'
		num2 = Integer.parseInt(arr1[1]); // integer '8'
		sum = num1 + num2; // ���� 14
		str = Integer.toString(sum); // string '14'
		if (str.length() == 1) {
			str = "0" + str;
		}
		String[] arr2 = str.split(""); // string array {1, 4}
		str = num2 + arr2[1]; // string '84'
		result = Integer.parseInt(str); // integer '84'
		return result;
	}

}
