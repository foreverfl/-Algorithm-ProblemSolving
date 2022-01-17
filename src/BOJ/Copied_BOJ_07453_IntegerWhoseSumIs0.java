package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_07453_IntegerWhoseSumIs0 {

	static int N;
	static long ans;
	static int[] A, B, C, D;
	static int[] AB, CD;
	static int ABPointer, CDPointer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];
		AB = new int[N * N];
		CD = new int[N * N];
		ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}

		ABPointer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AB[ABPointer] = A[i] + B[j];
				CD[ABPointer] = C[i] + D[j];
				ABPointer++;
			}
		}
		CDPointer = ABPointer - 1;

		Arrays.sort(AB);
		Arrays.sort(CD);

		for (int i = 0; i < ABPointer && CDPointer >= 0;) {
			int ABsum = AB[i];
			int CDsum = CD[CDPointer];
			int ABcnt = 0;
			int CDcnt = 0;
			int sum = ABsum + CDsum;
			if (sum == 0) {
				while (i < ABPointer && ABsum == AB[i]) { // including a duplicate value
					i++;
					ABcnt++;
				}
				while (CDPointer >= 0 && CDsum == CD[CDPointer]) { // including a duplicate value
					CDPointer--;
					CDcnt++;
				}

				ans += (long) ABcnt * (long) CDcnt; // 4-1-3. AB count * CD count
			} else if (sum > 0) {
				CDPointer--;
			} else {
				i++;
			}
		}

		bw.write(String.valueOf(ans) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}

// reference: https://subbak2.tistory.com/24