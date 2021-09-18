package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_GasStation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Long N = Long.parseLong(br.readLine());

		String str = br.readLine();
		StringTokenizer st1 = new StringTokenizer(str);

		long distance[] = new long[(int) (N - 1)];
		long city[] = new long[(int) (N + 1)];
		long answer[] = new long[(int) (N - 1)];
		long sum = 0;

		for (int i = 0; i < distance.length; i++) {
			distance[i] = Long.parseLong(st1.nextToken()); // Without the 'Long.parseLong()', can't get full score.
		}

		str = br.readLine();
		StringTokenizer st2 = new StringTokenizer(str);
		for (int i = 0; i < city.length - 1; i++) {
			city[i] = Long.parseLong(st2.nextToken());
			if (city[i + 1] > city[i]) {
				city[i + 1] = city[i];
			}
		}

		for (int i = 0; i < city.length - 1; i++) { // If gas cost of a next city is more expensive than the former one,
													// the gas cost is substituted.
			if (city[i + 1] > city[i]) {
				city[i + 1] = city[i];
			}
		}

		for (int i = 0; i < answer.length; i++) {
			answer[i] = distance[i] * city[i];
			sum += answer[i];
		}
		sb.append(sum);
		System.out.println(sb);
	}

}
