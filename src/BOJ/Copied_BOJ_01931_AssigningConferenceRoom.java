package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Copied_BOJ_01931_AssigningConferenceRoom {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[][] time = new int[T][2]; // time[][0] �� ��������, time[][1] �� �������

		StringTokenizer st;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken()); // start time
			time[i][1] = Integer.parseInt(st.nextToken()); // end time
		}

		// It arranges on the basis of end time.
		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				// If end times is same, it arranges in the basis of start times.
				// (1, 3), (8, 8), (4, 8) ��
				// (1, 3), (4, 8), (8, 8) ��
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}

				return o1[1] - o2[1];
			}

		});

//		for(int i=0; i<T; i++) {
//			for(int j=0; j <time[i].length; j++) {
//				System.out.print(time[i][j] + " ");
//			}
//			System.out.println();
//		}

		int count = 0;
		int prev_end_time = 0;

		for (int i = 0; i < T; i++) {

			// If a previous end time is shorter(or same) than a next conference start time,
			// count will increase.
			if (prev_end_time <= time[i][0]) {
				prev_end_time = time[i][1];
				count++;
			}
		}

		System.out.println(count);
	}

}
