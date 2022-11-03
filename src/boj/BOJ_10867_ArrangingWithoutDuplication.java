package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_10867_ArrangingWithoutDuplication {

	static Set<Integer> treeset = new TreeSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		while (N-- > 0) {
			treeset.add(Integer.parseInt(st.nextToken()));
		}

		for (int i : treeset) {
			System.out.print(i + " ");
		}

	}

}
