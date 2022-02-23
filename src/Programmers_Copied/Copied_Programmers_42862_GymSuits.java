package Programmers_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_Programmers_42862_GymSuits {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		List<Integer> lost_list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			lost_list.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		List<Integer> reserve_list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			reserve_list.add(Integer.parseInt(st.nextToken()));
		}

		int[] lost = lost_list.stream().mapToInt(i -> i).toArray();
		int[] reserve = reserve_list.stream().mapToInt(i -> i).toArray();

		int result = solution(N, lost, reserve);
		System.out.println(result);

	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		int[] status = new int[n];

		for (int i = 0; i < n; i++) // initializing all elements as '1'
			status[i] = 1;

		for (int l : lost) {
			status[l - 1]--;
		}

		for (int r : reserve) {
			status[r - 1]++;
		}

		for (int i = 0; i < n; i++) {

			if (status[i] == 0) { // If it were not for a gym suit.
				if (i - 1 >= 0 && status[i - 1] > 1) { // If a left person has more than one gym suit.
					status[i]++;
					status[i - 1]--;
					continue;
				}

				if (i + 1 < n && status[i + 1] > 1) { // If a right person has more than one gym suit.
					status[i]++;
					status[i + 1]--;
				}
			}
		}

		for (int i = 0; i < status.length; i++) {
			if (status[i] > 0)
				answer++;
		}

		return answer;
	}
}

// reference: https://binghedev.tistory.com/75
