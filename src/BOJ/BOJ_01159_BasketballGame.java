package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_01159_BasketballGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int[] cnt = new int[26]; // length of alphabet

		for (int i = 0; i < N; i++) {
			char temp = br.readLine().charAt(0);
			for (int j = 0; j < alphabet.length; j++) {
				if (alphabet[j] == temp) {
					cnt[j]++;
				}
			}
		}

		ArrayList<Character> arraylist = new ArrayList<>();

		for (int i = 0; i < alphabet.length; i++) {
			if (cnt[i] >= 5) {
				arraylist.add(alphabet[i]);
			}
		}

		Collections.sort(arraylist);

		String result = "";
		for (int i = 0; i < arraylist.size(); i++) {
			result += Character.toString(arraylist.get(i));
		}

		if (result.equals(""))
			System.out.println("PREDAJA");
		else
			System.out.println(result);

	}

}
