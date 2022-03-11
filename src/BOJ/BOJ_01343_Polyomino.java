package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01343_Polyomino {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String board = br.readLine();

		board = board.replaceAll("XXXX", "AAAA");
		board = board.replaceAll("XX", "BB");

		for (int i = 0; i < board.length(); i++) {
			if (board.charAt(i) == 'X') {
				System.out.println("-1");
				System.exit(0);
			}

		}
		System.out.println(board);
	}

}
