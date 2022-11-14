package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solving_BOJ_04887_JumpingBeans {

	private static class Bean {
		char name;
		int jump;

		public Bean() {

		}

		public Bean(char name, int cnt) {
			super();
			this.name = name;
			this.jump = cnt;
		}

		@Override
		public String toString() {
			return "Bean [name=" + name + ", cnt=" + jump + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int idx = 0;
		while (true) {
			System.gc();
			String res = "";

			++idx;
			String testCase = br.readLine();

			if (testCase.equals("0"))
				break;

			st = new StringTokenizer(testCase);
			int T = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			String[] S_split = S.split("");
			Bean[] arr = new Bean[S_split.length];
			for (int i = 0; i < S_split.length; i++) {
				Bean bean = new Bean();
				bean.name = S_split[i].charAt(0);
				bean.jump = 0;
				arr[i] = bean;
			}

			for (int i = 1; i <= T; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < arr.length; j++) {
					min = Math.min(min, arr[j].jump);
				}

				for (int j = 0; j < arr.length; j++) {
					if (arr[j].jump == min) {
						int move = i;
						arr[j].jump += 1;

						while (move-- > 0) {
							j = j % arr.length;
							arr = swap(arr, j++);
						}

//						System.out.println(i);
//						for (int k = 0; k < arr.length; k++) {
//							System.out.println(arr[k]);
//						}
//						System.out.println("===========");

						break;

					}
				}
			}

			for (int i = 0; i < arr.length; i++) {
				res += arr[i].name;
			}

			sb.append(idx + ". " + res).append('\n');

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static Bean[] swap(Bean[] arr, int idx) {

		int now = idx;
		int nxt = idx + 1;

		Bean tmp = new Bean(arr[idx].name, arr[idx].jump);

		// 제일 끝에 있는 요소라면
		if (now == arr.length - 1) {
			// 맨 앞으로 이동
			for (int i = arr.length - 1; i >= 1; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = tmp;
		} else {
			// 버블정렬
			arr[now].name = arr[nxt].name;
			arr[now].jump = arr[nxt].jump;
			arr[nxt].name = tmp.name;
			arr[nxt].jump = tmp.jump;
		}

		return arr;
	}

}
