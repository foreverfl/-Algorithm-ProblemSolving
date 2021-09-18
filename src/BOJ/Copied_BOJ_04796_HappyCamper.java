package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Copied_BOJ_04796_HappyCamper {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = 1;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken()); // limited
			int P = Integer.parseInt(st.nextToken()); // period
			int V = Integer.parseInt(st.nextToken()); // vacation
			if (L == 0) { // Break condition has to be set first.
				break;
			}
			
			int result = 0;
			result += ((V / P) * L);

			if (V % P <= L) {
				result += V % P;
			} else {
				result += L; // If the remainder is larger than the 'Limited'
			}

			sb.append("Case ");
			sb.append(T++);
			sb.append(": ");
			sb.append(result);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();

	}

}
