package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_01100_TheWhite {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		String[][] map = new String[8][8];

		for (int i = 0; i < map.length; i++) { // inputting the array
			String[] str = br.readLine().split("");
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = str[j];
			}
		}

//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[0].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		// (0, 0), (0, 2), (0, 4), (0, 6) �� coordinates of the white: Sum of (x, y) is
		// an even number.
		// (1, 1), (1, 3), (1, 5), (1, 7)
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if ((i + j) % 2 == 0 && map[i][j].equals("F")) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
