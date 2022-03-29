package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Copied_BOJ_01351_InfiniteProgression {

	static long N, P, Q;
	static Map<Long, Long> map = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());

		System.out.println(infiniteProgression(N));
	}

	// top -> bottom
	private static long infiniteProgression(long input) {

		if (input == 0)
			return 1;
		if (map.containsKey(input))
			return map.get(input);

		long left = (long) Math.floor(input / P);
		long right = (long) Math.floor(input / Q);
		map.put(input, infiniteProgression(left) + infiniteProgression(right));

		return map.get(input);
	}

}

// reference: https://loosie.tistory.com/251