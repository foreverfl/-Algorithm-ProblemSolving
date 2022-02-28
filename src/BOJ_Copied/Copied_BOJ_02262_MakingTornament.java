package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_02262_MakingTornament {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<Integer>();

		int min = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			list.add(Integer.parseInt(st.nextToken()));

		int max = n; // a player whose rank is the highest(whose number is the lowest)

		for (int i = 0; i < n - 1; i++) {
			int idx = list.indexOf(max); // the index of the player

			if (idx == 0)
				min += list.get(idx) - list.get(idx + 1);

			else if (idx == list.size() - 1)
				min += list.get(idx) - list.get(idx - 1);

			else
				min += Math.min(list.get(idx) - list.get(idx - 1), list.get(idx) - list.get(idx + 1));

			list.remove(idx);
			max--;
		}

		System.out.println(min);
	}

}


// reference: https://zzang9ha.tistory.com/70