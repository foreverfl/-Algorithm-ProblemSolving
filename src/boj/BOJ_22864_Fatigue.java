package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22864_Fatigue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int time = 0;
		int fatigue = 0;
		int work = 0;
		while (true) {
			time++;
			fatigue += A;
			work += B;

			if (fatigue > M) {
				fatigue -= A;
				work -= B;
				fatigue -= C;
				if (fatigue < 0) {
					fatigue = 0;
				}
			}

			if (time == 24)
				break;
		}

		System.out.println(work);
	}

}
