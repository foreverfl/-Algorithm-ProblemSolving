package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BOJ_03059_SumOfStringWhichDoesntAppear {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int sum = 2015;
		while (T-- > 0) {
			String input = br.readLine();

			Set<Character> set = new HashSet<>();

			for (int i = 0; i < input.length(); i++) {
				set.add(input.charAt(i));
			}

			Iterator<Character> iterator = set.iterator();
			while (iterator.hasNext()) {
				sum -= (int) iterator.next();
			}

			sb.append(sum).append('\n');

			sum = 2015; // initialization
		}

		System.out.println(sb.toString());
	}

}
