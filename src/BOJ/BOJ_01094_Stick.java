package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01094_Stick {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		String tmp = Integer.toBinaryString(input);

		int cnt = 0;
		for (int i = 0; i < tmp.length(); i++) {
			if (tmp.charAt(i) == '1')
				cnt++;
		}

		System.out.println(cnt);
	}

}
