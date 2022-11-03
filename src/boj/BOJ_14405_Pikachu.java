package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14405_Pikachu {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		if (str.matches("^(pi|ka|chu)*$"))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
