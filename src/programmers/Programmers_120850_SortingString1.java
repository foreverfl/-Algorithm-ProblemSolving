package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_120850_SortingString1 {

	public static void main(String[] args) {
		int[] arr;
		arr = solution("hi12392");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		arr = solution("p2o4i8gj2");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		arr = solution("abcde0");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	public static int[] solution(String my_string) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < my_string.length(); i++) {
			if (my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9') {
				list.add((int) my_string.charAt(i));
			}
		}

		int[] ans = new int[list.size()];
		int size = 0;
		for (int tmp : list) {
			ans[size++] = tmp - '0';
		}
		
		Arrays.sort(ans);

		return ans;
	}

}
