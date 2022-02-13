package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_10825_KoreanEnglishMath {
	static class Member implements Comparable<Member> {
		public String name;
		public int korean;
		public int english;
		public int math;

		public Member(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(Member o) {
			if (this.korean == o.korean && this.english == o.english && this.math == o.math) { // 4
				return this.name.compareTo(o.name);
			}

			if (this.korean == o.korean && this.english == o.english) { // 3
				return o.math - this.math;
			}

			if (this.korean == o.korean) { // 2
				return this.english - o.english;
			}
			return o.korean - this.korean; // 1
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		ArrayList<Member> member = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			member.add(new Member(name, korean, english, math));
		}

		Collections.sort(member);

		for (int i = 0; i < N; i++) {
			System.out.println(member.get(i).name);
		}
	}

}
