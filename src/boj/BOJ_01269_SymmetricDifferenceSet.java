package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BOJ_01269_SymmetricDifferenceSet {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		HashMap<Integer, Boolean> hashmap = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		while (A-- > 0) {
			int tmp = Integer.parseInt(st.nextToken());
			hashmap.put(tmp, true);
		}

		st = new StringTokenizer(br.readLine());
		while (B-- > 0) {
			int tmp = Integer.parseInt(st.nextToken());
			if (hashmap.containsKey(tmp)) {
				hashmap.put(tmp, false);
			} else {
				hashmap.put(tmp, true);
			}
		}

		int cnt = 0;
		for (Entry<Integer, Boolean> entrySet : hashmap.entrySet()) {
			int key = entrySet.getKey();
			boolean value = entrySet.getValue();
			if (value)
				cnt++;
		}

		System.out.println(cnt);

	}

}
