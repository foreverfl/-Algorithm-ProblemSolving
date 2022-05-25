package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_02501_FindingFactor {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				list.add(i);
			}
		}

		if (K - 1 >= list.size())
			System.out.println(0);
		else
			System.out.println(list.get(K - 1));

	}

}
