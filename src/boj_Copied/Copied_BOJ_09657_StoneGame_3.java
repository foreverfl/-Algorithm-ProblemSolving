package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_09657_StoneGame_3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		System.out.println((N % 7 == 0 || N % 7 == 2) ? "CY" : "SK");
	
	}
}

// reference: https://steady-coding.tistory.com/168