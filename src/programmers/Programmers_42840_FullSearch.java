package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_42840_FullSearch {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 3; i++) {
			System.out.print(solution(arr)[i] + " ");
		}

	}

	public static int[] solution(int[] answers) {
		int one_cnt = 0, two_cnt = 0, three_cnt = 0;

		int[] one_key = { 1, 2, 3, 4, 5 };
		int[] one = new int[answers.length];
		for (int i = 0; i < one.length; i++) {
			one[i] = one_key[i % one_key.length];
			if (answers[i] == one[i]) {
				one_cnt++;
			}
		}

		int[] two_key = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] two = new int[answers.length];
		for (int i = 0; i < two.length; i++) {
			two[i] = two_key[i % two_key.length];
			if (answers[i] == two[i]) {
				two_cnt++;
			}
		}

		int[] three_key = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[] three = new int[answers.length];
		for (int i = 0; i < three.length; i++) {
			three[i] = three_key[i % three_key.length];
			if (answers[i] == three[i]) {
				three_cnt++;
			}
		}

		// finding max
		List<Integer> list = new ArrayList<>();
		int max = Integer.MIN_VALUE;

		if (one_cnt >= max) {
			max = one_cnt;
		}

		if (two_cnt >= max) {
			max = two_cnt;
		}

		if (three_cnt >= max) {
			max = three_cnt;
		}

		if (one_cnt == max) {
			list.add(1);
		}

		if (two_cnt == max) {
			list.add(2);
		}

		if (three_cnt == max) {
			list.add(3);
		}

		int[] answer = new int[list.size()];

		int size = 0;

		for (int tmp : list) {
			answer[size++] = tmp;
		}

		return answer;
	}
}
