package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_13413_ReassigningOthello {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int transWCount = 0, transBCount = 0;

			String start = br.readLine(), target = br.readLine();

			for (int i = 0; i < N; i++) {
				if (start.charAt(i) != target.charAt(i)) {
					if (start.charAt(i) == 'W')
						transBCount++;
					else
						transWCount++;
				}
			}

			if (transBCount >= transWCount)
				sb.append(transBCount);
			else
				sb.append(transWCount);

			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

}

// reference: https://velog.io/@phjppo0918/%EB%B0%B1%EC%A4%80-13413-%EC%98%A4%EC%85%80%EB%A1%9C-%EC%9E%AC%EB%B0%B0%EC%B9%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-JAVA