package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20291_OrganizingFile {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> hashmap = new HashMap<>();

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine(), ".");
			String name = st.nextToken();
			String extension = st.nextToken();

			if (!hashmap.containsKey(extension))
				hashmap.put(extension, 1);
			else
				hashmap.replace(extension, hashmap.get(extension) + 1);
		}

		List<String> list = new ArrayList<>(hashmap.keySet());

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + " " + hashmap.get(list.get(i))).append('\n');
		}

		System.out.println(sb.toString());

	}

}
