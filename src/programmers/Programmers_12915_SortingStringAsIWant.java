package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Programmers_12915_SortingStringAsIWant {

	public static void main(String[] args) {
		String[] arr = solution(new String[] { "ccc", "aaa", "bbb" }, 1);
		System.out.println(Arrays.toString(arr));

	}

	public static String[] solution(String[] strings, int n) {
		int size = strings.length;
		List<String> list = new ArrayList<>();

		for (String str : strings) {
			list.add(str);
		}

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.charAt(n) == o2.charAt(n)) {

					return o1.compareTo(o2);
				}

				return o1.charAt(n) - o2.charAt(n);
			}

		});

		String[] answer = new String[size];
		for (int i = 0; i < size; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
