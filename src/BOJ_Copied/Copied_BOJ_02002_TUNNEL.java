package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Copied_BOJ_02002_TUNNEL {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Map<String, Integer> in = new LinkedHashMap<>();
		for (int i = 0; i < N; i++) {
			in.put(br.readLine(), i);
		}

		int[] out = new int[N];
		for (int i = 0; i < N; i++) {
			out[i] = in.get(br.readLine()); // order of car which gets out
		}

		int cnt = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (out[i] > out[j]) { // cutting in line
					cnt++;
					break;
				}
			}
		}

		System.out.println(cnt);
	}

}

// reference: https://velog.io/@pss407/%EB%B0%B1%EC%A4%802002-%EC%B6%94%EC%9B%94
