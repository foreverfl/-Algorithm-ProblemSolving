package BOJ_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Copied_BOJ_01764_PersonWhoIsStrange {
	public static int N, M;
	public static HashSet<String> hs = new HashSet<String>();
	public static ArrayList<String> answer = new ArrayList<String>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			hs.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (hs.contains(s)) {
				answer.add(s);
			}

		}
		
		Collections.sort(answer);
		
		System.out.println(answer.size());
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}

	}

}

// reference: https://soboruya.tistory.com/4