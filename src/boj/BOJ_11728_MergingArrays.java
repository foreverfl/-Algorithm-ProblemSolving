package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11728_MergingArrays {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Integer[] A = new Integer[N];
		int M = Integer.parseInt(st.nextToken());
		Integer[] B = new Integer[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> A_list = new ArrayList<>(Arrays.asList(A));
		List<Integer> B_list = new ArrayList<>(Arrays.asList(B));
		A_list.addAll(B_list); // A_list = A_list + B_list

		Collections.sort(A_list);

		for (int i = 0; i < A_list.size(); i++) {
			bw.append(A_list.get(i) + " ");
		}
		
		bw.flush();
		bw.close();
		
	}
}
