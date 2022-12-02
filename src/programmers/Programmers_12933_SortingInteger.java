package programmers;

import java.util.Arrays;

public class Programmers_12933_SortingInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long solution(long n) {
		String str = Long.toString(n);
		char[] arr = str.toCharArray();
		Arrays.sort(arr);

		char[] reversed = new char[arr.length];
		for (int i = 0; i < reversed.length; i++) {
			reversed[i] = arr[reversed.length - 1 - i];
		}

		str = "";
		for (int i = 0; i < reversed.length; i++) {
			str += reversed[i];
		}

		long answer = Long.parseLong(str);
		return answer;
	}

}
