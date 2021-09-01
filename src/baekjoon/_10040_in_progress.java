package baekjoon;

import java.io.*;
import java.util.*;

public class _10040_in_progress {

	public class Main {
		public static void main(String[] args) throws IOException {
			//
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//
 			StringTokenizer st = new StringTokenizer(br.readLine());
 			// (Reference) StringTokenizer
			int N = Integer.parseInt(st.nextToken()); // the number of competition
			int M = Integer.parseInt(st.nextToken()); // the number of committee
			// (Reference) String java.util.StringTokenizer.nextToken()
			int[] match = new int[N];
			int[] person = new int[M];
			int[] result = new int[N];
			int max = 0;
			int cnt = 0;
			
			// ���� �Է°� �ޱ�
			for (int i = 0; i < N; i++) {
				match[i] = Integer.parseInt(br.readLine());
				result[i] = 0;
			}
			// ���� �Է°� �ޱ�
			for (int i = 0; i < M; i++) {
				person[i] = Integer.parseInt(br.readLine());
			}
			for (int i = 0; i < M; i++) { // ����
				out: for (int j = 0; j < N; j++) { // ��������
					if (match[j] <= person[i]) {
						result[j]++;
						break out;
					}
				}
			}
			for (int i = 0; i < result.length; i++) {
				if (result[i] > max) {
					max = result[i];
					cnt = i + 1;
				}
			}
			System.out.println(cnt);
		}

	}
}
