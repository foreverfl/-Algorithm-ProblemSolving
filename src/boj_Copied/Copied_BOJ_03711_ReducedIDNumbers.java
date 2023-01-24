package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Copied_BOJ_03711_ReducedIDNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int G = Integer.parseInt(br.readLine());

			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < G; j++) {
				list.add(Integer.parseInt(br.readLine()));
			}

			if (G == 1) {
				System.out.println(1);
				continue;
			}

			int m = 2;
			while (true) {
				List<Integer> remainList = new ArrayList<>();

				for (int j = 0; j < G; j++) {
					int tmp = list.get(j) % m;

					if (remainList.contains(tmp)) {
						break;
					}

					remainList.add(tmp);
				}

				if (remainList.size() == G) {
					System.out.println(m);
					break;
				}

				m++;
			}
		}
	}

}

// reference: https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-3711%EB%B2%88-%ED%95%99%EB%B2%88-%EC%9E%90%EB%B0%94JAVA