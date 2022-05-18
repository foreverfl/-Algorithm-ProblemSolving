package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_13164_HappinessKindergarten {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		List<Integer> list = new ArrayList<>();
		List<Integer> diff = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		// making a list for difference
		for (int i = 0; i < list.size() - 1; i++) {
			diff.add(list.get(i + 1) - list.get(i));
		}

		Collections.sort(diff);

		int result = 0;

		for (int i = 0; i < N - K; i++) {
			result += diff.get(i);
		}

		System.out.print(result);
	}

}

// reference: https://c-king.tistory.com/258
