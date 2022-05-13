package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_11508_AKCIJA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list, Collections.reverseOrder());

		int total = 0;
		int free = 0;

		for (int i = 0; i < N; i++) {
			total += list.get(i);

			if (i % 3 == 2) {
				free += list.get(i);
			}
		}

		int ans = total - free;

		System.out.println(ans);

	}

}
