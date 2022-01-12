package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Copied_BOJ_01806_ThePartOfSum {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long S = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 100001, sum = 0;
		int firstPointer = 0, secondPointer = 0;
		while (true) {
			if (sum >= S) {
				sum -= arr[firstPointer++]; // Moving the 'firstPointer' to the right, it subtracts its value to the sum.
				answer = Math.min(answer, (secondPointer - firstPointer) + 1);
			} else if (secondPointer == N)
				break;
			else
				sum += arr[secondPointer++]; // Moving the 'secondPointer' to the right, it adds its value to the sum.
		}
		if (answer == 100001) {
			bw.write(0 + "\n");
		} else {
			bw.write(answer + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}

// reference: https://blog.crazzero.com/m/28
