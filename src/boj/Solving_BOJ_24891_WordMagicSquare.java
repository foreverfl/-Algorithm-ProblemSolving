package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solving_BOJ_24891_WordMagicSquare {

	/*
	 * 1. 단어 알파벳 순으로 정렬
	 * 2. 단어 경우의 수 모두 조회(백트래킹)
	 * 3. 답이 나오면 그 경우의 수를 출력
	 * 4. 그렇지 않으면 NONE을 출력
	 */

	private static int L, N;
	private static List<String> words = new ArrayList<>();
	private static boolean[] visited;
	private static int[] arr;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			words.add(br.readLine());
		}
		visited = new boolean[N];
		arr = new int[N];

		Collections.sort(words);

		backTracking(0);

		bw.write("NONE");
		bw.flush();
		bw.close();

	}

	private static void backTracking(int depth) throws IOException {
		if (depth == L) {
			List<String> tmp = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				tmp.add(words.get(arr[i]));
			}

			char[][] square = makeSquare(tmp);

			if (isPossible(square)) {
				for (int i = 0; i < L; i++) {
					for (int j = 0; j < L; j++) {
						sb.append(square[i][j]);
					}
					sb.append('\n');
				}

				bw.write(sb.toString());
				bw.flush();
				bw.close();

				System.exit(0);
			}

			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				arr[depth] = i;
				visited[i] = true;
				backTracking(depth + 1);
				visited[i] = false;
			}
		}

	}

	private static char[][] makeSquare(List<String> words) {
		char[][] res = new char[L][L];

		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				res[i][j] = words.get(i).charAt(j);
			}
		}

		return res;
	}

	private static boolean isPossible(char[][] square) {
		String horizontal = "";
		String vertical = "";

		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				horizontal += square[i][j];
				vertical += square[j][i];
			}
		}

		if (horizontal.equals(vertical)) {
			return true;
		} else {
			return false;
		}
	}

}
