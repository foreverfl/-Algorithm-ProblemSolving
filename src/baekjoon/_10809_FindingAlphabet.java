package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10809_FindingAlphabet {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char arr[] = str.toCharArray(); // char array a p p l e
		char arrcopied[] = Arrays.copyOf(arr, 26);

		char alphabet[] = new char[26];
		int answer[] = new int[26];
		for (int i = 0; i < 26; i++) {
			alphabet[i] = (char) (i + 97); // lower case
			for (int j = 0; j < 26; j++) {
				if (alphabet[i] == arrcopied[i]) {
					answer[i] = i;
				} else {
					answer[i] = -1;
				}
			}
		}
		for (int i = 0; i < 26; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}
