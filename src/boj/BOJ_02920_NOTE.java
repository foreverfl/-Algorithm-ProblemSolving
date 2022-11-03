package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02920_NOTE {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String ascending = "1 2 3 4 5 6 7 8";
		String descending = "8 7 6 5 4 3 2 1";

		if (str.equals(ascending))
			System.out.println("ascending");
		else if (str.equals(descending))
			System.out.println("descending");
		else
			System.out.println("mixed");
	}

}
