package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10951_APlusBMinus4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		while ((str = br.readLine()) != null) { // Unless there is input, it will exit.
			StringTokenizer st = new StringTokenizer(str, " ");
			int result = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			System.out.println(result);

		}
	}

}
