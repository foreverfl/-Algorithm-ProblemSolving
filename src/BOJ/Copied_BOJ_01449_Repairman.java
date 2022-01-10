package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_01449_Repairman {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int L = Integer.parseInt(str[1]);
		int position[] = new int[1001];
		int tape = 0;
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			position[Integer.parseInt(input[i])] = 1;
		}

		for (int i = 1; i <= 1000; i++) {
			if (position[i] != 0) {
				i += L - 1; // skip
				tape++;
			}
		}

		System.out.println(tape);
	}

}
