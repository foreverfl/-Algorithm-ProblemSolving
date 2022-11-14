package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_03003_BIJELE {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int king = Integer.parseInt(st.nextToken());
		int queen = Integer.parseInt(st.nextToken());
		int look = Integer.parseInt(st.nextToken());
		int bishop = Integer.parseInt(st.nextToken());
		int knight = Integer.parseInt(st.nextToken());
		int pawn = Integer.parseInt(st.nextToken());
		int kingAns = 0, queenAns = 0, lookAns = 0, bishopAns = 0, kinghtAns = 0, pawnAns = 0;

		kingAns = 1 - king;
		queenAns = 1 - queen;
		lookAns = 2 - look;
		bishopAns = 2 - bishop;
		kinghtAns = 2 - knight;
		pawnAns = 8 - pawn;

		System.out
				.println(kingAns + " " + queenAns + " " + lookAns + " " + bishopAns + " " + kinghtAns + " " + pawnAns);

	}

}
