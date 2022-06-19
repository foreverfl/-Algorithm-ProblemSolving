package Programmers_Copied;

import java.util.Arrays;
import java.util.Comparator;

public class Copied_Programmers_42746_MaximumNumber {

	public static void main(String[] args) {
		int[] numbers_1 = { 6, 10, 2 };
		System.out.println(solution(numbers_1));

		int[] numbers_2 = { 3, 30, 34, 5, 9 };
		System.out.println(solution(numbers_2));

	}

	public static String solution(int[] numbers) {
		String ans = "";

		String[] arr = new String[numbers.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.toString(numbers[i]);
		}

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});

		if (arr[0].equals("0"))
			return "0";

		for (String str : arr) {
			ans += str;
		}
		return ans;
	}
}

//reference: https://ivory-room.tistory.com/43
