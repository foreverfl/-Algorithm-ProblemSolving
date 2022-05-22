package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_01822_DifferenceOfSets {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		Set<Integer> set = new TreeSet<>();

		st = new StringTokenizer(br.readLine());
		while (A-- > 0) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		while (B-- > 0) {
			int tmp = Integer.parseInt(st.nextToken());
			if (set.contains(tmp))
				set.remove(tmp);
		}

		sb.append(set.size()).append('\n');

		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			sb.append(iterator.next() + " ");
		}

		System.out.println(sb.toString());
	}

}
