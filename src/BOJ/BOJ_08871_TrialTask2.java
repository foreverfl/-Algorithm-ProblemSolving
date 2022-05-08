package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_08871_TrialTask2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int min = (n + 1) * 2;
		int max = (n + 1) * 3;

		System.out.println(min + " " + max);
	}

}
