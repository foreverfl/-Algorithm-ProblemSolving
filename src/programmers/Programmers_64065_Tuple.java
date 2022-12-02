package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Programmers_64065_Tuple {

	public static void main(String[] args) {
		int[] arr = solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
		System.out.println(Arrays.toString(arr));

	}

	public static int[] solution(String s) {
		List<String> list = new ArrayList<>();

		String[] arr = s.split("\\{\\{|\\}\\,\\{|\\}\\}");
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].equals(""))
				list.add(arr[i]);
		}

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}

		});

		Set<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i < list.size(); i++) {
			StringTokenizer st = new StringTokenizer(list.get(i), ",");
			while (st.hasMoreTokens()) {
				set.add(Integer.parseInt(st.nextToken()));
			}
		}

		int[] ans = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		int idx = 0;
		while (iterator.hasNext()) {
			ans[idx++] = iterator.next();
		}
		return ans;
	}

}
