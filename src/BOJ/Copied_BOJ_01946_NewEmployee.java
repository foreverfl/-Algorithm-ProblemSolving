package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01946_NewEmployee {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) { // the number of test case input
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n + 1];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				a[x] = y; // It makes a pair such as 'a[3] = 2'.
				// Rating is not duplicated.
				// It arrange elements on basis of the 'x' automatically.
			}

			int cnt = 1; // if the 'x' is '1', this is possible.
			int standard = a[1]; // It means the standard is value of the 'y' when 'x=1'.
			for (int i = 2; i <= n; i++) {
				if (standard > a[i]) { // If the value of the 'a[i]' is smaller than standard(y),
					cnt++;
					standard = a[i]; // the 'standard' is substituted the value of the 'a[i]'.
				}
			}
			System.out.println(cnt);
		}
	}

}