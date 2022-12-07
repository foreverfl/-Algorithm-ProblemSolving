package programmers;

import java.util.Arrays;

public class Programmers_12917_SortingStringInDescendingOrder {

	public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));

	}

	public static String solution(String s) {
		int size = s.length();
		char[] arr = s.toCharArray();
		Arrays.sort(arr);

		char[] arr_2 = new char[size];
		for (int i = 0; i < size; i++) {
			arr_2[i] = arr[size - i - 1];
		}
		String answer = String.valueOf(arr_2);

		return answer;
	}

}
