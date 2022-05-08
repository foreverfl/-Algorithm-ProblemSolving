package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_13904_Assignment {

	static class Assignment {
		int day;
		int score;

		Assignment(int day, int score) {
			this.day = day;
			this.score = score;
		}
	}

	static Assignment[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		arr = new Assignment[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[i] = new Assignment(d, w);
		}

		Arrays.sort(arr, new Comparator<Assignment>() {
			@Override
			public int compare(Assignment o1, Assignment o2) {
				return Integer.compare(o1.score, o2.score);
			}

		});

	}

}
