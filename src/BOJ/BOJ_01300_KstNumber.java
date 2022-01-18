package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_01300_KstNumber {

	static int N, k;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());


		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				list.add(i * j);
			}
		}

		Collections.sort(list);
		
		System.out.println(list.get(k));

	}

}
