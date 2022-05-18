package BOJ_Copied;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Copied_BOJ_01448_MakingTriangle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list, Collections.reverseOrder());

		int ans = -1;
		for (int i = 0; i < N - 2; i++) {
			if (list.get(i) < list.get(i + 1) + list.get(i + 2)) {
				ans = Math.max(ans, list.get(i) + list.get(i + 1) + list.get(i + 2));
			}

		}

		bw.write(ans + " ");
		bw.flush();
		bw.close();

	}

}

// reference: https://codingtalk.tistory.com/325
