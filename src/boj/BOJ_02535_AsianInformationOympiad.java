package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_02535_AsianInformationOympiad {

	static class Student implements Comparable<Student> {
		int nation;
		int num;
		int score;

		Student(int nation, int num, int score) {
			this.nation = nation;
			this.num = num;
			this.score = score;
		}

		@Override
		public int compareTo(Student o) {
			return o.score - this.score;
		}

		@Override
		public String toString() {
			return "Student [nation=" + nation + ", num=" + num + ", score=" + score + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Student[] arr = new Student[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int nation = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			arr[i] = new Student(nation, num, score);
		}

		Arrays.sort(arr);

//		for (int i = 0; i < N; i++) {
//			System.out.println(arr[i]);
//		}

		int[] nations = new int[N + 1]; // excluding zero
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			nations[arr[i].nation]++;
			if (nations[arr[i].nation] < 3) {
				sb.append(arr[i].nation + " " + arr[i].num).append('\n');
				cnt++;
			}

			if (cnt > 2)
				break;

		}

		System.out.print(sb.toString());

	}

}
