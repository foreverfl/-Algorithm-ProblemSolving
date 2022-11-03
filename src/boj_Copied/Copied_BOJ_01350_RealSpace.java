package boj_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Copied_BOJ_01350_RealSpace {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		ArrayList<Long> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			long a = Long.parseLong(st.nextToken());
			
			if (a == 0)
				continue;

			list.add(a);
		}

		int cluster = Integer.parseInt(br.readLine());
		
		long ans = 0L;
		for (int i = 0; i < list.size(); i++) {
			ans += (long) list.get(i) % cluster == 0 ? (long) cluster * list.get(i) / cluster
					: (long) cluster * (list.get(i) / cluster + 1);
		}
		sb.append(ans);
		
		System.out.println(sb.toString());
	}
}

// reference: https://blog.crazzero.com/m/99