package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_14698_TenSura_Hard {

	static final long mod = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			PriorityQueue<Long> pq = new PriorityQueue<>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while (N-- > 0) {
				pq.add(Long.parseLong(st.nextToken()));
			}

			long ans = 1L;
			while (pq.size() != 1) {
				long A = pq.poll();
				long B = pq.poll();
				long tmp = A * B;
				pq.add(tmp);
				ans = ans * (tmp % mod) % mod;
			}
			sb.append(ans).append('\n');

		}

		System.out.println(sb.toString());

	}
}

// refernece: https://lovelyunsh.tistory.com/65
