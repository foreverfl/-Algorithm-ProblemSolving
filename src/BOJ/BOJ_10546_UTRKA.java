package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_10546_UTRKA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> hashmap = new HashMap<>();

		int repeat = N;
		while (repeat-- > 0) {
			String name = br.readLine();
			if (!hashmap.containsKey(name))
				hashmap.put(name, 1);
			else
				hashmap.put(name, hashmap.get(name) + 1);

		}

		repeat = N - 1;
		while (repeat-- > 0) {
			String name = br.readLine();
			hashmap.replace(name, hashmap.get(name) - 1);
		}

		for (Map.Entry<String, Integer> entryset : hashmap.entrySet()) {
			String key = entryset.getKey();
			int value = entryset.getValue();

			if (value != 0)
				System.out.println(key);
		}
	}

}
