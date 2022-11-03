package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Copied_BOJ_02910_SORT {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> hashmap = new LinkedHashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			int input = Integer.parseInt(st.nextToken());
			hashmap.put(input, hashmap.getOrDefault(input, 0) + 1);
		}

		ArrayList<Integer> value = new ArrayList<Integer>(hashmap.keySet());

		Collections.sort(value, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return Integer.compare(hashmap.get(b), hashmap.get(a));
			}
		});

		Iterator<Integer> iterator = value.iterator();
		while (iterator.hasNext()) {
			Integer element = iterator.next();
			for (int i = 0; i < hashmap.get(element); i++) {
				System.out.print(element + " ");
			}

		}

	}

}

// reference: https://zoonvivor.tistory.com/132