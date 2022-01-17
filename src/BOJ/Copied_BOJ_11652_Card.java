package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class Copied_BOJ_11652_Card {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<BigInteger, Integer> hm = new HashMap<>(N); // key, value
		for (int i = 0; i < N; i++) {
			BigInteger biginteger = new BigInteger(br.readLine());
			if (hm.containsKey(biginteger))
				hm.put(biginteger, hm.get(biginteger) + 1);
			else
				hm.put(biginteger, 1);
		}
		System.out.print(hm.entrySet().stream().sorted((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
				.max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())).get().getKey());
	}
}

// reference: https://dalconbox.tistory.com/184