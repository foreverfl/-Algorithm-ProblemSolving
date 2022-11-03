package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_09273_PlantingTrees {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Integer[] trees = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(trees, Collections.reverseOrder());
		
		int max = 0;
		for (int i = 0; i < N; i++) { // days for growing + days for plating
			trees[i] = trees[i] + i + 1;
			
			if (trees[i] > max)
				max = trees[i];
		}
		System.out.println(max + 1);

	}

}

// reference: https://soboruya.tistory.com/49
