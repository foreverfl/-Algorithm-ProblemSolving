package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BOJ_11507_KARTE {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		List<String> list = new ArrayList<>();
		Set<Integer> P = new HashSet<>();
		Set<Integer> K = new HashSet<>();
		Set<Integer> H = new HashSet<>();
		Set<Integer> T = new HashSet<>();

		for (int i = 0; i < str.length() - 2; i = i + 3) {
			String tmp = str.substring(i, i + 3);
			list.add(tmp);
		}

		for (int i = 0; i < list.size(); i++) {
			String tmp = list.get(i);
			String shape = tmp.substring(0, 1);
			int number = Integer.parseInt(tmp.substring(1, 3));

			if (shape.equals("P")) {
				if (P.contains(number)) {
					System.out.println("GRESKA");
					System.exit(0);
				} else
					P.add(number);
			} else if (shape.equals("K")) {
				if (K.contains(number)) {
					System.out.println("GRESKA");
					System.exit(0);
				} else
					K.add(number);
			} else if (shape.equals("H")) {
				if (H.contains(number)) {
					System.out.println("GRESKA");
					System.exit(0);
				} else
					H.add(number);
			} else if (shape.equals("T")) {
				if (T.contains(number)) {
					System.out.println("GRESKA");
					System.exit(0);
				} else
					T.add(number);
			}
		}

		System.out.println((13 - P.size()) + " " + (13 - K.size()) + " " + (13 - H.size()) + " " + (13 - T.size()));

	}

}
