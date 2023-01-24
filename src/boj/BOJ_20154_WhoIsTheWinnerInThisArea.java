package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_20154_WhoIsTheWinnerInThisArea {

	public static void main(String[] args) throws IOException {
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 3);
		map.put('B', 2);
		map.put('C', 1);
		map.put('D', 2);
		map.put('E', 3);
		map.put('F', 3);
		map.put('G', 3);
		map.put('H', 3);
		map.put('I', 1);
		map.put('J', 1);
		map.put('K', 3);
		map.put('L', 1);
		map.put('M', 3);
		map.put('N', 3);
		map.put('O', 1);
		map.put('P', 2);
		map.put('Q', 2);
		map.put('R', 2);
		map.put('S', 1);
		map.put('T', 2);
		map.put('U', 1);
		map.put('V', 1);
		map.put('W', 2);
		map.put('X', 2);
		map.put('Y', 2);
		map.put('Z', 1);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int points = 0;
		for (int i = 0; i < str.length(); i++) {
			points += map.get(str.charAt(i));
		}

		if (points % 2 == 0) {
			System.out.print("You're the winner?");
		} else {
			System.out.print("I'm a winner!");
		}
	}

}
