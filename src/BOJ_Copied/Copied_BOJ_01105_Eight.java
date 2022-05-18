package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01105_Eight {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String L = st.nextToken();
		String R = st.nextToken();

		int cnt = 0;
		if (L.length() == R.length()) {
			for (int i = 0; i < L.length(); i++) {
				if (L.charAt(i) != R.charAt(i)) {
					break;
				} else {
					if (L.charAt(i) == '8') {
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);

	}

}

// reference: https://kjs-dev.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%9E%90%EB%B0%94-1105-%ED%8C%94