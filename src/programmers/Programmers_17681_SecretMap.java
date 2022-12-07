package programmers;

import java.util.Arrays;

public class Programmers_17681_SecretMap {

	public static void main(String[] args) {
		String[] arr = solution(6, new int[] { 46, 33, 33, 22, 31, 50 }, new int[] { 27, 56, 19, 14, 14, 10 });
		System.out.println(Arrays.toString(arr));
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			String save = "";
			int sum = arr1[i] | arr2[i];
			String str = Integer.toBinaryString(sum);
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '1') {
					save += "#";
				} else {
					save += " ";
				}
			}

			while (save.length() != n) {
				save = " " + save;
			}
			answer[i] = save;
		}

		return answer;
	}

}
