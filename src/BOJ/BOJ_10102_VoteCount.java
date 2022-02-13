package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10102_VoteCount {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		String vote = br.readLine();

		int count_A = 0;
		int count_B = 0;
		for (int i = 0; i < V; i++) {
			if (vote.charAt(i) == 'A')
				count_A++;
			else
				count_B++;
		}

		if (count_A > count_B)
			System.out.println("A");
		else if (count_B > count_A)
			System.out.println("B");
		else
			System.out.println("Tie");
	}

}
