package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_86051_AddingNumbersNotExisting {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = solution(arr);
		System.out.println(result);

	}

	public static int solution(int[] numbers) {
		int answer = 0;

		List<Integer> numbers_list = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			numbers_list.add(numbers[i]);
		}

		for (int i = 0; i < 10; i++) {
			if (!numbers_list.contains(i)) {
				answer += i;
			}
		}

		return answer;
	}

}
