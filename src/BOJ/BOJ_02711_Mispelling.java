package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_02711_Mispelling {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int where = Integer.parseInt(st.nextToken());
			String input = st.nextToken();

			StringBuilder sb = new StringBuilder(input);
			sb.deleteCharAt(where - 1);
			bw.append(sb).append('\n');
		}

		bw.flush();
		bw.close();

	}

}
