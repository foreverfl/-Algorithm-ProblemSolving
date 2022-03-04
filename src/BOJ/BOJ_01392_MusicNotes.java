package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_01392_MusicNotes {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		List<Integer> note = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			int repeat = Integer.parseInt(br.readLine());
			while (repeat-- > 0) {
				note.add(i);
			}
		}

		for (int i = 0; i < Q; i++) {
			int question = Integer.parseInt(br.readLine());

			sb.append(note.get(question)).append('\n');
		}
		
		System.out.println(sb.toString());

	}

}
