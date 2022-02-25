package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Copied_BOJ_14425_SetOfStrings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 1);
		}
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (map.get(str) != null) {
				cnt++;
			}
		}
		sb.append(cnt + "\n");
		System.out.println(sb.toString());
	}
}

// reference: https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-14425-%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%A7%91%ED%95%A9-java