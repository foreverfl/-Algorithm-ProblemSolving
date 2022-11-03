package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_02183_TennisGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String S = st.nextToken();
		
		System.out.println(S.charAt(S.length() - 1)); // The person who get the last ball can win the game.
	}

}

// reference: https://comengin.tistory.com/m/304