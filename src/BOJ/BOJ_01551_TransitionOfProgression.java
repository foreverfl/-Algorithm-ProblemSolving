package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_01551_TransitionOfProgression {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), ",");
		while (st.hasMoreTokens())
			list.add(Integer.parseInt(st.nextToken()));

		while (K-- > 0) {
			list = makeProgression(list);
		}
		for (int i = 0; i < list.size(); i++) {
			if (i != list.size() - 1)
				System.out.print(list.get(i) + ",");
			else
				System.out.print(list.get(i));
		}
	}

	private static List<Integer> makeProgression(List<Integer> list) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < list.size() - 1; i++) {
			result.add(list.get(i + 1) - list.get(i));
		}

		return result;

	}

}
