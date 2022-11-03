package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_02659_CrossSignCardProblem {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[4];
		for (int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		String input = makeNumber(arr);

		Set<String> set = new HashSet<>();

		for (int i = 1; i <= 9; i++) {
			int[] arr_tmp = new int[4];
			arr_tmp[0] = i;
			for (int j = 1; j <= 9; j++) {
				arr_tmp[1] = j;
				for (int k = 1; k <= 9; k++) {
					arr_tmp[2] = k;
					for (int l = 1; l <= 9; l++) {
						arr_tmp[3] = l;
						String str = makeNumber(arr_tmp);
						set.add(str);
					}
				}
			}
		}

		List<String> list = new ArrayList<>(set);
		Collections.sort(list);

		int ans = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(input)) {
				ans = i + 1;
			}
		}

		System.out.println(ans);

	}

	private static String makeNumber(int[] arr) {

		Set<String> set = new HashSet<>();

		for (int i = 0; i < 4; i++) {
			String tmp = "";
			for (int j = i; j < 4; j++) {
				tmp += Integer.toString(arr[j]);
			}

			for (int j = 0; j < i; j++) {
				tmp += Integer.toString(arr[j]);
			}
			set.add(tmp);
		}

		List<String> list = new ArrayList<>(set);
		Collections.sort(list);

		return list.get(0);
	}

}
