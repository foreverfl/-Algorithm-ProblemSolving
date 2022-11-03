package programmers_Copied;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Copied_Programmers_42627_DiskController {

	public static void main(String[] args) {
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		int res = solution(jobs);
		System.out.println(res);
	}

	public static int solution(int[][] jobs) {

		int total = 0;
		int end = 0;
		int idx = 0; // jobs' index
		int cnt = 0;

		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		while (cnt < jobs.length) {

			// inputing all requests until the end
			while (idx < jobs.length && jobs[idx][0] <= end)
				pq.add(jobs[idx++]);

			if (pq.isEmpty()) {
				end = jobs[idx][0];

			} else {
				int[] now = pq.poll();
				total += now[1] + end - now[0];
				end += now[1];
				cnt++;
			}
		}

		return total / jobs.length;
	}
}

// reference: https://codevang.tistory.com/316
