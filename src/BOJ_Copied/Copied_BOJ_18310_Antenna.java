package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_18310_Antenna {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);

		int median = (N - 1) / 2;

		System.out.println(list.get(median));
	}

}

// reference: https://velog.io/@minuk1236/%EB%B0%B1%EC%A4%80-%EC%95%88%ED%85%8C%EB%82%98-18310