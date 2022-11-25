package programmers;

import java.util.Arrays;

public class Programmers_120923_SumOfContinuousNumbers {

	public static void main(String[] args) {
		int[] arr;

		arr = solution(3, 12);
		System.out.println(Arrays.toString(arr));

		arr = solution(5, 15);
		System.out.println(Arrays.toString(arr));

		arr = solution(4, 14);

		System.out.println(Arrays.toString(arr));

		arr = solution(5, 5);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] solution(int num, int total) {
		int sum = 0;
		for (int i = 0; i < num; i++) {
			sum += i;
		}

		int start = 0;
		int[] answer = {};
		if (total > sum) {
			while (total != sum) {
				answer = makeArray(num, start++);
				sum = makeSum(answer);
			}
		} else if (total < sum) {
			while (total != sum) {
				answer = makeArray(num, start--);
				sum = makeSum(answer);
			}
		} else {
			answer = makeArray(num, start);
		}

		return answer;
	}

	private static int[] makeArray(int len, int start) {
		int[] arr = new int[len];

		for (int i = 0; i < len; i++) {
			arr[i] = start++;
		}

		return arr;
	}

	private static int makeSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		return sum;
	}

}
