package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_01083_Sort {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		int S = Integer.parseInt(br.readLine());

		int moveCnt = 0, changeIdx = 0;
		while (moveCnt < S && changeIdx < N - 1) {
			int maxNum = list.get(changeIdx), maxIdx = -1;

			int idx = changeIdx + 1, count = 1;
			while (moveCnt + count <= S && idx < N) {
				int num = list.get(idx);
				if (num > maxNum) {
					maxNum = num;
					maxIdx = idx;
				}
				count++;
				idx++;
			}

			if (maxIdx != -1) {
				list.remove(maxIdx);
				list.add(changeIdx, maxNum);
				moveCnt += maxIdx - changeIdx;
			}
			changeIdx++;
		}

		for (int i : list) {
			sb.append(i).append(' ');
		}
		
		System.out.println(sb);
	}

}
