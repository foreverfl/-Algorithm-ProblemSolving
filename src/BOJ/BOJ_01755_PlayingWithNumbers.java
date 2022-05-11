package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_01755_PlayingWithNumbers {
	static class Number implements Comparable<Number> {
		String num;
		String read;

		Number(String num, String read) {
			this.num = num;
			this.read = read;
		}

		@Override
		public String toString() {
			return num;
		}

		@Override
		public int compareTo(Number o) {
			return this.read.compareTo(o.read);
		}

	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		List<String> list = new ArrayList<>();
		for (int i = M; i <= N; i++) {
			list.add(Integer.toString(i));
		}

		
		List<Number> ans = makeList(list);
		Collections.sort(ans);
		Iterator<Number> iterator = ans.iterator();
		int idx = 0;
		while (iterator.hasNext()) {
			idx++;
			if (idx <= 10) {
				sb.append(iterator.next() + " ");
			} else {
				sb.append('\n');
				idx = 0;
			}

		}

		System.out.println(sb.toString());

	}

	private static List<Number> makeList(List<String> list) {
		List<Number> res = new ArrayList<>();

		Map<Integer, String> map = new HashMap<>();
		map.put(0, "zero");
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");

		for (int i = 0; i < list.size(); i++) {
			String num = list.get(i);
			String read = "";
			for (int j = 0; j < num.length(); j++) {
				read += map.get((int) (num.charAt(j) - '0'));
			}
			res.add(new Number(num, read));

		}

		return res;
	}
}
