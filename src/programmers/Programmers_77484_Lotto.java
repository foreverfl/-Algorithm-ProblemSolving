package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_77484_Lotto {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] lottos = new int[6];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			lottos[i] = Integer.parseInt(st.nextToken());
		}

		int[] win_nums = new int[6];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			win_nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] result = solution(lottos, win_nums);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		int match = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (lottos[i] == win_nums[j] && lottos[i] != 0)
					match++;

			}
		}

		int cnt_0 = 0;
		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0)
				cnt_0++;
		}

		int max = match + cnt_0; 
		int min = match;

		int[] answer = { rank(max), rank(min) };
		return answer;
	}

	public static int rank(int a) {
		if (a == 6)
			return 1;
		else if (a == 5)
			return 2;
		else if (a == 4)
			return 3;
		else if (a == 3)
			return 4;
		else if (a == 2)
			return 5;
		else
			return 6;
	}
}
