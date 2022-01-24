package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_04999_aah {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		String second = br.readLine();

		int cnt_first = 0;
		int cnt_second = 0;

		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) == 'a')
				cnt_first++;
		}

		for (int i = 0; i < second.length(); i++) {
			if (second.charAt(i) == 'a')
				cnt_second++;
		}

		if (cnt_first >= cnt_second)
			System.out.println("go");
		else
			System.out.println("no");
	}

}
