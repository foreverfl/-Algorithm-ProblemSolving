package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_05014_Startlink {

	static int F, S, G, U, D;
	static int current;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken()); // floor
		S = Integer.parseInt(st.nextToken()); // start
		G = Integer.parseInt(st.nextToken()); // goal
		U = Integer.parseInt(st.nextToken()); // up
		D = Integer.parseInt(st.nextToken()); // down
		arr = new int[F + 1];

		System.out.println(bfs());

	}

	private static String bfs() {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(S);
		arr[S] = 1;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (current == G) {
				return Integer.toString(arr[current] - 1);
			}

			if (current + U <= F) {
				if (arr[current + U] == 0) { // not visited
					arr[current + U] = arr[current] + 1;
					queue.add(current + U);
				}

			}

			if (current - D > 0) {
				if (arr[current - D] == 0) { // not visited
					arr[current - D] = arr[current] + 1;
					queue.add(current - D);
				}
			}

		}

		return "use the stairs";
	}

}

// reference: https://zoonvivor.tistory.com/144