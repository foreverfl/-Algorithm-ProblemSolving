package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_17471_Gerrymandering {

	static int people[];
	static int N;
	static boolean matrix[][];
	static int min = 123456789;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		people = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			people[i] = Integer.parseInt(st.nextToken());

		matrix = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int etc = Integer.parseInt(st.nextToken());
			for (int j = 0; j < etc; j++) {
				int target = Integer.parseInt(st.nextToken());
				matrix[i][target] = true;
				matrix[target][i] = true;
			}
		}

		for (int i = 1; i <= ((1 << N) - 1) / 2; i++) {
			ArrayList<Integer> section_1 = makeSection(i);
			if (!check(section_1)) // If not connected, ignore.
				continue;

			ArrayList<Integer> section_2 = makeSection((1 << N) - 1 - i);
			if (!check(section_2))
				continue;

			int diff = Math.abs(getPeople(section_1) - getPeople(section_2));
			min = Math.min(diff, min);
		}
		if (min == 123456789)
			min = -1;
		System.out.println(min);

	}

	static ArrayList<Integer> makeSection(int Section) {
		ArrayList<Integer> section = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			if ((Section & (1 << i)) != 0)
				section.add(i + 1);
		}
		return section;
	}

	static boolean check(ArrayList<Integer> originSection) {
		ArrayList<Integer> section = (ArrayList<Integer>) originSection.clone();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(section.get(0));
		section.remove(0);
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = section.size() - 1; i >= 0; i--) {
				if (matrix[now][section.get(i)]) {
					queue.offer(section.get(i));
					section.remove(i);
				}
			}
		}
		if (section.size() == 0) // If connected.
			return true;
		return false;
	}

	static int getPeople(ArrayList<Integer> section) {
		int sum = 0;
		for (int i : section)
			sum += people[i];
		return sum;
	}
}

// reference: https://lovelyunsh.tistory.com/9