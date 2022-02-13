package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_12015_AnIncreasingPartOfProgression {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		List<Integer> list = new ArrayList<>();
		list.add(Integer.MIN_VALUE);

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int value = arr[i] = Integer.parseInt(st.nextToken());
			if (value > list.get(list.size() - 1))
				list.add(value);
			else {
				int left = 0;
				int right = list.size() - 1;

				while (left < right) {
					int mid = (left + right) >> 1; // The '>>1' means the quotient of '/2'.
					if (list.get(mid) >= value) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
				list.set(right, value);
			}
		}
		System.out.println(list.size() - 1);
	}

}

// reference: https://dragon-h.tistory.com/2