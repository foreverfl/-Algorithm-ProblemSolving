package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_01092_Ship {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<Integer> crane = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			crane.add(Integer.parseInt(st.nextToken()));

		int M = Integer.parseInt(br.readLine());
		List<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			box.add(Integer.parseInt(st.nextToken()));

		Collections.sort(crane, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());

		if (box.get(0) > crane.get(0)) {
			System.out.println("-1");
			System.exit(0);

		}

		int ans = 0;
		while (true) {
			int idx = 0; // the left boxes because of crane's size
			for (int i = 0; i < crane.size();) {
				if (idx == box.size())
					break;
				else if (crane.get(i) >= box.get(idx)) {
					box.remove(idx);
					i++;
				} else
					idx++;
			}
			ans++;

			if (box.isEmpty())
				break;
		}

		System.out.println(ans);

	}

}

// reference: https://moonsbeen.tistory.com/202
