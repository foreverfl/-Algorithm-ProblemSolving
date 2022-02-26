package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_01296_NamingTeamName {

	static String name;
	static int N;
	static String[] team;
	static int[] possiblity;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		name = br.readLine();

		N = Integer.parseInt(br.readLine());
		team = new String[N];
		possiblity = new int[N];
		for (int i = 0; i < N; i++) {
			team[i] = br.readLine();
			possiblity[i] = LOVE(name, team[i]);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (possiblity[i] > max) {
				max = possiblity[i];
			}
		}

		List<String> ans = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (possiblity[i] == max) {
				ans.add(team[i]);
			}
		}

		Collections.sort(ans);

		System.out.println(ans.get(0));

	}

	private static int LOVE(String a, String b) {
		int L = 0;
		int O = 0;
		int V = 0;
		int E = 0;

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == 'L')
				L++;
			if (a.charAt(i) == 'O')
				O++;
			if (a.charAt(i) == 'V')
				V++;
			if (a.charAt(i) == 'E')
				E++;
		}

		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == 'L')
				L++;
			if (b.charAt(i) == 'O')
				O++;
			if (b.charAt(i) == 'V')
				V++;
			if (b.charAt(i) == 'E')
				E++;
		}

		int result = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;

		return result;
	}

}
