package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Copied_BOJ_17255_MakingToN {

	static char[] arr;
	static Set<String> set;

	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = st.nextToken().toCharArray();
		set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			dfs(i, i, "" + arr[i], "" + arr[i]);
		}
		System.out.println(set.size());
	}

	public static void dfs(int L, int R, String str, String path) {
		if (L == 0 && R == arr.length - 1) {
			set.add(path);
			return;
		}
		if (L - 1 >= 0) {
			dfs(L - 1, R, arr[L - 1] + str, path + " " + arr[L - 1] + str);
		}
		if (R + 1 < arr.length) {
			dfs(L, R + 1, str + arr[R + 1], path + " " + str + arr[R + 1]);
		}
	}
}

// reference: https://moons-memo.tistory.com/249
