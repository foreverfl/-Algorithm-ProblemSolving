package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_120833_CuttingArray {

	public static void main(String[] args) {
		int[] arr = solution(new int[] { 1, 2, 3, 4, 5 }, 1, 3);
		System.out.println(Arrays.toString(arr));

		arr = solution(new int[] { 1, 3, 5 }, 1, 2);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] solution(int[] numbers, int num1, int num2) {
		List<Integer> list = new ArrayList<>();

		for (int i = num1; i <= num2; i++) {
			list.add(numbers[i]);
		}

		int[] arr = new int[list.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
		}

		return arr;
	}

}
